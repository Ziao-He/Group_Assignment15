/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

/**
 *
 * @author Administrator
 */
public class Course {
    private String courseId;
    private String name;
    private int credits;
    private String description;
    private String syllabus;

    public Course(String courseId, String name, int credits){
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
    }    

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getSyllabus() {
        return syllabus;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
