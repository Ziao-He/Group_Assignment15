/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import Business.Profiles.FacultyProfile;

/**
 *
 * @author Administrator
 */
public class CourseOffering {
    private Course course;
//    private Faculty faculty;
    private FacultyProfile faculty;
    private String semester;
    private int capacity;
    private double tuitionPerCredit = 300.0; 

    public Course getCourse() {
        return course;
    }

    public FacultyProfile getFaculty() {
        return faculty;
    }


    public String getSemester() {
        return semester;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public double getTuitionForCourse(){
        return course.getCredits()*tuitionPerCredit;
    }
    
    public CourseOffering(Course course, FacultyProfile faculty, String semester, int capacity){
        this.course = course;
        this.faculty = faculty;
        this.semester = semester;
        this.capacity = capacity;
    }
}
