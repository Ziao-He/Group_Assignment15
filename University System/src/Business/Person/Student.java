/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.CourseGrade;
import Business.Course.CourseOffering;
import Paymenet.PaymentRecord;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Student extends Person {
    private String studentId;
    private String name;
    private double balance = 0.0; 
    private ArrayList<CourseOffering> enrolledOfferings = new ArrayList<>();
    private ArrayList<CourseGrade> transcript = new ArrayList<>();
    private ArrayList<PaymentRecord> payments = new ArrayList<>();
//    private ArrayList<AssignmentSubmission> submissions = new ArrayList<>();

    public Student(String studentId, String name, String role) {
        super(role);  
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CourseOffering> getEnrolledOfferings() {
        return enrolledOfferings;
    }

    public void setEnrolledOfferings(ArrayList<CourseOffering> enrolledOfferings) {
        this.enrolledOfferings = enrolledOfferings;
    }

    public ArrayList<CourseGrade> getTranscript() {
        return transcript;
    }

    public void setTranscript(ArrayList<CourseGrade> transcript) {
        this.transcript = transcript;
    }

    public ArrayList<PaymentRecord> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<PaymentRecord> payments) {
        this.payments = payments;
    }
    
//    Enroll
    public boolean enrollCourse(CourseOffering offering){
        if (offering == null) return false;
        int credits = offering.getCourse().getCredits();
        if (getTotalCreditHours() + credits > 8) return false; 
        if (enrolledOfferings.contains(offering)) return false;
        enrolledOfferings.add(offering);
        double tuition = offering.getTuitionForCourse();
        this.balance += tuition;
        payments.add(new PaymentRecord(new Date(), tuition, "Charge: Tuition for " + offering.getCourse().getCourseId(), "CHARGED"));
        return true;
    }

    public boolean dropCourse(CourseOffering offering){
        if (!enrolledOfferings.contains(offering)) return false;
        enrolledOfferings.remove(offering);
        double tuition = offering.getTuitionForCourse();
        this.balance -= tuition;
        payments.add(new PaymentRecord(new Date(), -tuition, "Refund: " + offering.getCourse().getCourseId(), "REFUNDED"));
        return true;
    }

    public int getTotalCreditHours(){
        int sum = 0;
        for (CourseOffering o : enrolledOfferings)
            sum += o.getCourse().getCredits();
        return sum;
    }

//    Payment
    public double getBalance() { 
        return balance; 
    }

    public double payTuition(double amount){
        double paid = amount;
        this.balance -= paid;
        payments.add(new PaymentRecord(new Date(), paid, "Payment", "PAID"));
        return paid;
    }

//    Transcript
    public void addCourseGrade(CourseGrade cg){ transcript.add(cg); }

    public double calculateTermGPA(String term){
        double totalQuality = 0.0;
        int totalCredits = 0;
        for (CourseGrade cg : transcript){
            if (term.equals(cg.getTerm()) && cg.getGrade() != null){
                totalQuality += cg.getGradePoint() * cg.getCourse().getCredits();
                totalCredits += cg.getCourse().getCredits();
            }
        }
        return totalCredits == 0 ? 0.0 : totalQuality / totalCredits;
    }

    public double calculateOverallGPA(){
        double totalQuality = 0.0;
        int totalCredits = 0;
        for (CourseGrade cg : transcript){
            if (cg.getGrade() != null){
                totalQuality += cg.getGradePoint() * cg.getCourse().getCredits();
                totalCredits += cg.getCourse().getCredits();
            }
        }
        return totalCredits == 0 ? 0.0 : totalQuality / totalCredits;
    }

    public String getAcademicStandingForTerm(String term){
        double termGPA = calculateTermGPA(term);
        double overallGPA = calculateOverallGPA();
        if (overallGPA < 3.0) return "Academic Probation";
        if (termGPA < 3.0) return "Academic Warning";
        return "Good Standing";
    }

//    Graduation
    public boolean readyToGraduate_MSIS(){
        int earnedCredits = 0;
        boolean hasCore = false;
        for (CourseGrade cg : transcript){
            if (cg.getGrade() != null && !cg.getGrade().equalsIgnoreCase("F")){
                earnedCredits += cg.getCourse().getCredits();
                if ("INFO 5100".equalsIgnoreCase(cg.getCourse().getCourseId())) hasCore = true;
            }
        }
        return earnedCredits >= 32 && hasCore;
    }

//    // ================= Coursework =================
//    public void submitAssignment(String courseId, String title, String content){
//        AssignmentSubmission s = new AssignmentSubmission(courseId, title, content, new Date());
//        submissions.add(s);
//    }

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}
