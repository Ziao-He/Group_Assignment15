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
                "Tuition charge: " + courseId + " (" + semester + ")", "CHARGED"));

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
                "Refund for " + course.getCourseId(), "REFUNDED"));

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


// Coursework
    public String submitAssignment(String courseId, String title, String content) {
        if (courseId == null || title == null || content == null || courseId.isEmpty() || title.isEmpty()) {
            return "Invalid assignment submission.";
        }
        AssignmentSubmission s = new AssignmentSubmission(courseId, title, content, new Date());
        submissions.add(s);

        String msg = String.format("✅ Submitted assignment '%s' for %s at %s.", title, courseId, new Date());
        System.out.println("[LOG] " + msg);
        JOptionPane.showMessageDialog(null, msg, "Submission Success", JOptionPane.INFORMATION_MESSAGE);
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

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}

