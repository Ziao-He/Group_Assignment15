/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.FacultyRole;

import Business.Business;
import Business.Course.CourseGrade;
import Business.Course.CourseOffering;
import Business.Person.Student;
import Business.UserAccounts.UserAccount;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author yujie-liang
 */
public class PerformanceReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PerformanceReportJPanel
     */
    
    javax.swing.JPanel CardSequencePanel;
    Business business;
    UserAccount useraccount;
    ArrayList<CourseOffering> facultyCourse;
    CourseOffering courseOffering = null;
    ArrayList<Student> studentDirectory;
    Map<String, Integer> gradeCount = new HashMap<>();


    public PerformanceReportJPanel(Business b, JPanel clp, UserAccount ua) {

        business = b;
        this.CardSequencePanel = clp;
        useraccount = ua;
        initComponents();
        facultyCourse = business.getCourseDirectory().findByFacultyName(useraccount.getPersonId());
        
        initializationBoxSemester();
    }
    
    public void initializationBoxSemester(){ 
        boxSemester.removeAllItems();
        if(facultyCourse != null)
            for(CourseOffering co : facultyCourse){
                boolean NOexists = true;
                for (int i = 0; i < boxSemester.getItemCount(); i++) 
                    if (boxSemester.getItemAt(i).equals(co.getSemester())) {
                        NOexists = false;
                        break;
                    }
                if(NOexists)
                    boxSemester.addItem(co.getSemester());
                
            }
  
        
    }
    
    public void initializationBoxCourse(){
        boxCourse.removeAllItems();
        String Semester = (String) boxSemester.getSelectedItem();
        if(facultyCourse != null)
            for(CourseOffering co : facultyCourse)
                if(co.getSemester().equals(Semester))
                    boxCourse.addItem(co.getCourse().getName());
    }    
        
    
    public void refresh(){
        String Semester = (String) boxSemester.getSelectedItem();
        String Course = (String) boxCourse.getSelectedItem();
        //find courseOffering
        for(CourseOffering co : facultyCourse)
            if(co.getCourse().getName().equals(Course) && co.getSemester().equals(Semester)){
                courseOffering = co;
                break;
            }
        
        studentDirectory = business.getStudentDirectory().findEnrollStudent(courseOffering);
        if(studentDirectory != null){
            double SumGPA =0;
            // use Map store grade-letter count
                for (Student s : studentDirectory) 
                    for(CourseGrade cg : s.getTranscript()){
                    String gletter = cg.getGradeLetterByCourse(courseOffering.getCourse());
                    SumGPA = SumGPA + cg.getGpaByCourse(courseOffering.getCourse());
                    if(!gradeCount.containsKey(gletter))
                        gradeCount.put(gletter, 1);
                    else 
                        gradeCount.put(gletter, gradeCount.get(gletter) + 1);

                }

                double average = Math.round(SumGPA / studentDirectory.size() * 100.0) / 100.0;
                txtAverageGrade.setText(Double.toString(average));
                txtCount.setText(Integer.toString(studentDirectory.size()));

                //refresh table GRADE
                DefaultTableModel model =(DefaultTableModel) tblGrade.getModel();
                model.setRowCount(0);

                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblGrade.getModel());
                sorter.setComparator(2, Comparator.comparingDouble(o -> ((Number) o).doubleValue()));
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();;
                sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();

                tblGrade.setRowSorter(sorter);
                    for(Map.Entry<String, Integer> entry : gradeCount.entrySet())
                        { 
                            Object row[]= new Object[3];   
                            row[0] = entry.getKey();
                            row[1] = entry.getValue();                     
                            row[2] = getGradePoint(entry.getKey());
                            model.addRow(row);
                        }

            }else{
            DefaultTableModel model =(DefaultTableModel) tblGrade.getModel();
            model.setRowCount(0);
            txtAverageGrade.setText("");
            txtCount.setText("");

        }
            
        
            
        
    }
    public double getGradePoint(String grade){
        if (grade == null) return 0.0;
        switch(grade){
            case "A": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B": return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C": return 2.0;
            case "C-": return 1.7;
            default: return 0.0; 
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        boxCourse = new javax.swing.JComboBox<>();
        lblCourse = new javax.swing.JLabel();
        lblSemester = new javax.swing.JLabel();
        boxSemester = new javax.swing.JComboBox<>();
        lblAverageGrade = new javax.swing.JLabel();
        txtAverageGrade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrade = new javax.swing.JTable();
        lblCount = new javax.swing.JLabel();
        txtCount = new javax.swing.JTextField();
        btnExport = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTitle.setText("Performance Reporting");

        boxCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCourseActionPerformed(evt);
            }
        });

        lblCourse.setText("Course");

        lblSemester.setText("Semester");

        boxSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSemesterActionPerformed(evt);
            }
        });

        lblAverageGrade.setText("Average grade");

        tblGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Grade", "Count", "order"
            }
        ));
        jScrollPane1.setViewportView(tblGrade);
        if (tblGrade.getColumnModel().getColumnCount() > 0) {
            tblGrade.getColumnModel().getColumn(2).setMinWidth(0);
            tblGrade.getColumnModel().getColumn(2).setPreferredWidth(0);
            tblGrade.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        lblCount.setText("Enrollment count");

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTitle)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAverageGrade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAverageGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCount)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCourse)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boxCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSemester)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boxSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(92, 92, 92)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(btnExport)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSemester))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAverageGrade)
                    .addComponent(txtAverageGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCount)
                    .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport)
                .addContainerGap(367, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSemesterActionPerformed
        // TODO add your handling code here:
        initializationBoxCourse();
    }//GEN-LAST:event_boxSemesterActionPerformed

    private void boxCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCourseActionPerformed
        // TODO add your handling code here:
        gradeCount.clear();
        refresh();
    }//GEN-LAST:event_boxCourseActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        String Semester = (String) boxSemester.getSelectedItem();
        String Course = (String) boxCourse.getSelectedItem();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(Semester + " " + Course + " performance reports");
        chooser.setFileFilter(new FileNameExtensionFilter("TXT file (*.txt)", "txt"));

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                
                // wirte Semester Course Grade
                writer.println("Semester: "+Semester);
                writer.println("Course: "+ Course);
                writer.println("Average Grade: " + txtAverageGrade.getText());
                writer.println("Enrollment Count: " + txtCount.getText());
                
                

                // write to the tableGrade header
                for (int i = 0; i < tblGrade.getColumnCount()-1; i++) {
                    writer.print(tblGrade.getColumnName(i));
                    if (i < tblGrade.getColumnCount() - 2) writer.print(",");
                }
                writer.println();

                // wirte every line
                for (int r = 0; r < tblGrade.getRowCount(); r++) {
                    for (int c = 0; c < tblGrade.getColumnCount()-1; c++) {
                        Object value = tblGrade.getValueAt(r, c);
                        writer.print(value == null ? "" : value.toString());
                        if (c < tblGrade.getColumnCount() - 2) writer.print(",");
                    }
                    writer.println();
                }

                writer.flush();
                JOptionPane.showMessageDialog(null, "export successful：" + file.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "export failed：" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.remove(this);
        CardLayout layout = (CardLayout) CardSequencePanel.getLayout();
        layout.previous(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCourse;
    private javax.swing.JComboBox<String> boxSemester;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAverageGrade;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblGrade;
    private javax.swing.JTextField txtAverageGrade;
    private javax.swing.JTextField txtCount;
    // End of variables declaration//GEN-END:variables
}
