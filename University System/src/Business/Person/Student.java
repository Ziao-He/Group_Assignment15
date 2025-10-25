/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.Course;
import Business.Course.CourseGrade;
import Business.Course.CourseOffering;
import Paymenet.PaymentRecord;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Student extends Person {
    private String studentId;
    private String name;
    private String email;
    private String Phone;        
    private double balance = 0.0; 
    private ArrayList<CourseOffering> enrolledOfferings = new ArrayList<>();
    private ArrayList<CourseGrade> transcript = new ArrayList<>();
    private ArrayList<PaymentRecord> payments = new ArrayList<>();
    private ArrayList<AssignmentSubmission> submissions = new ArrayList<>();

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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSubmissions(ArrayList<AssignmentSubmission> submissions) {
        this.submissions = submissions;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<AssignmentSubmission> getSubmissions() {
        return submissions;
    }
    
    public String enrollCourse(CourseOffering offering) {
        if (offering == null || offering.getCourse() == null) return "Invalid course offering.";

        Course course = offering.getCourse();
        String courseId = course.getCourseId();
        String semester = offering.getSemester();

        for (CourseOffering o : enrolledOfferings) {
            if (o.getCourse().getCourseId().equalsIgnoreCase(courseId)) {
                return "Already enrolled in " + courseId;
            }
        }

        int semesterCredits = 0;
        for (CourseOffering o : enrolledOfferings) {
            if (o.getSemester().equalsIgnoreCase(semester)) semesterCredits += o.getCourse().getCredits();
        }
        if (semesterCredits + course.getCredits() > 8) {
            return "Exceed 8 credit limit in semester " + semester;
        }

        int earnedCredits = 0;
        for (CourseGrade cg : transcript) {
            if (cg.getGrade() != null && !cg.getGrade().equalsIgnoreCase("F")) earnedCredits += cg.getCourse().getCredits();
        }
        int totalCredits = earnedCredits + getTotalCreditHours() + course.getCredits();
        if (totalCredits > 32) return "Total credits exceed 32 (degree limit).";

        enrolledOfferings.add(offering);
        balance += offering.getTuitionForCourse();
        payments.add(new PaymentRecord(new Date(), offering.getTuitionForCourse(),
                "Tuition charge: " + courseId + " (" + semester + ")", "CHARGED",course));

        String msg = String.format("✅ Enrolled %s (%s). Tuition: %.2f, Balance: %.2f",
                courseId, semester, offering.getTuitionForCourse(), balance);
        System.out.println("[LOG] " + msg);
        JOptionPane.showMessageDialog(null, msg, "Enroll Success", JOptionPane.INFORMATION_MESSAGE);
        return "OK";
    }

// Drop
    public String dropCourse(CourseOffering offering) {
        if (offering == null || offering.getCourse() == null) return "Invalid course offering.";
        Course course = offering.getCourse();
        CourseOffering target = null;
        for (CourseOffering o : enrolledOfferings) {
            if (o.getCourse().getCourseId().equalsIgnoreCase(course.getCourseId())
                    && o.getSemester().equalsIgnoreCase(offering.getSemester())) {
                target = o;
                break;
            }
        }
        if (target == null) return "Not enrolled in " + course.getCourseId();

        enrolledOfferings.remove(target);
        balance -= target.getTuitionForCourse();
        payments.add(new PaymentRecord(new Date(), -target.getTuitionForCourse(),
                "Refund for " + course.getCourseId(), "REFUNDED",course));

        String msg = String.format("✅ Dropped %s (%s). Refund: %.2f. New balance: %.2f",
                course.getCourseId(), target.getSemester(), target.getTuitionForCourse(), balance);
        System.out.println("[LOG] " + msg);
        JOptionPane.showMessageDialog(null, msg, "Drop Success", JOptionPane.INFORMATION_MESSAGE);
        return "OK";
    }


// Payment
    public String payTuition(double amount) {
        if (amount <= 0) return "Payment must be positive.";
        if (balance <= 0) return "No outstanding balance to pay.";

        balance -= amount;
        payments.add(new PaymentRecord(new Date(), amount, "Tuition Payment", "PAID"));

        String msg = String.format("✅ Paid $%.2f. Remaining balance: $%.2f", amount, balance);
        System.out.println("[LOG] " + msg);
        JOptionPane.showMessageDialog(null, msg, "Payment Success", JOptionPane.INFORMATION_MESSAGE);
        return "OK";
    }

    public double getTotalPaidForCourse(Course course) {
    double paid = 0.0;
    for (PaymentRecord pr : payments) {
        if (course.getCourseId().equals(pr.getCourseID()) && pr.getStatus().equals("PAID")) {
            paid += pr.getAmout();
        }
    }
    return paid;
}

    public double getTotalChargedForCourse(Course course) {
        double charged = 0.0;
        for (PaymentRecord pr : payments) {
            if (course.getCourseId().equals(pr.getCourseID()) && pr.getStatus().equals("CHARGED")) {
                charged += pr.getAmout();
            }
        }
        return charged;
    }

    public boolean isCoursePaid(Course course) {
        return getTotalPaidForCourse(course) >= getTotalChargedForCourse(course);
    }

// Coursework
    public String submitAssignment(CourseWork cw, String content) {
        if (cw == null || content == null || content.trim().isEmpty()) {
            return "Missing input fields.";
        }

        boolean enrolled = false;
        for (CourseOffering offering : enrolledOfferings) {
            if (offering.getCourse().getCourseId().equalsIgnoreCase(cw.getCourse().getCourseId())) {
                enrolled = true;
                break;
            }
        }
        if (!enrolled) {
            return "You are not enrolled in course: " + cw.getCourse().getCourseId();
        }

        for (AssignmentSubmission sub : submissions) {
            if (sub.getCoursework().getCourse().getCourseId().equalsIgnoreCase(cw.getCourse().getCourseId())
                    && sub.getCoursework().getTitle().equalsIgnoreCase(cw.getTitle())) {
                return "You have already submitted this assignment: " + cw.getTitle();
            }
        }

        AssignmentSubmission newSubmission = new AssignmentSubmission(this,cw, content,new Date());

        submissions.add(newSubmission);
        return "OK";
    
}

//Profile
    public String updateProfile(String newName) {
        if (newName == null || newName.isEmpty()) return "Name cannot be empty.";
        String oldName = this.name;
        this.name = newName;
        String msg = String.format("✅ Updated profile: name '%s' → '%s'", oldName, newName);
        System.out.println("[LOG] " + msg);
        JOptionPane.showMessageDialog(null, msg, "Profile Updated", JOptionPane.INFORMATION_MESSAGE);
        return "OK";
    }

    public int getTotalCreditHours() {
        int sum = 0;
        for (CourseOffering o : enrolledOfferings)
            sum += o.getCourse().getCredits();
        return sum;
    }
    
    public double calculateOverallGPA() {
    double totalQualityPoints = 0.0;
    int totalCredits = 0;

    for (CourseGrade cg : transcript) {
        if (cg.getGrade() != null ) {
            totalQualityPoints += cg.getGradePoint() * cg.getCourse().getCredits();
            totalCredits += cg.getCourse().getCredits();
        }
    }

    return totalCredits == 0 ? 0.0 : totalQualityPoints / totalCredits;
}
    
    public double calculateTermGPA(String term) {
        double totalQualityPoints = 0.0;
        int totalCredits = 0;

        for (CourseGrade cg : transcript) {
            if (term.equalsIgnoreCase(cg.getTerm()) && cg.getGrade() != null) {
                double gradePoint = cg.getGradePoint();
                int credits = cg.getCourse().getCredits();
                totalQualityPoints += gradePoint * credits;
                totalCredits += credits;
                }
            }

            return totalCredits == 0 ? 0.0 : totalQualityPoints / totalCredits;
    }

    public String getAcademicStandingForTerm(String term) {
        double termGPA = calculateTermGPA(term);
        double overallGPA = calculateOverallGPA();

        if (overallGPA < 3.0) {
            return "Academic Probation";
        } else if (termGPA < 3.0) {
            return "Academic Warning";
        } else {
            return "Good Standing";
        }
    }
    
    public void addCourseGrade(Course course,String term,String grade, Double gpa){
        if(course == null || term == null || grade == null){
            System.out.println("ERRO GRADE INPUT FOR STUDENT");
            return;
        }
        
        CourseGrade cg = new CourseGrade(course,term,grade,gpa);
        transcript.add(cg);
        
    }
    
    @Override
    public String toString() {
        return studentId + " - " + name;
    }
    
    
}

