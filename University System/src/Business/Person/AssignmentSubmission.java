/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.Course;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class AssignmentSubmission {
    private CourseWork coursework;
    private Student student;
    private String content;
    private Date submittedOn;
    private String grade; 

    public AssignmentSubmission(Student student,CourseWork courseWork, String content, Date submittedOn){
        this.student = student;
        this.coursework = courseWork;
        this.content = content; 
        this.submittedOn = submittedOn;
        this.grade="Pending";
    }    

    public Student getStudent() {
        return student;
    }

    public CourseWork getCoursework() {
        return coursework;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean IsSubmissionThisCourseAssignment(Course c){
        if(c.getName().equals(this.coursework.getCourse().getName()))
            return true;
        return false;
    }
    
}
