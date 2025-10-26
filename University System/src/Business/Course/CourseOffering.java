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
    private FacultyProfile faculty;
    private Schedule schedule;
    private int capacity;
    private double tuitionPerCredit = 300.0; 
    private boolean enrollmentStatus = true;

    public Course getCourse() {
        return course;
    }

    public FacultyProfile getFaculty() {
        return faculty;
    }


    public String getSemester() {
        return schedule.getSemester();
    }

    public int getCapacity() {
        return capacity;
    }
    
    
    public double getTuitionForCourse(){
        return course.getCredits()*tuitionPerCredit;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public boolean isEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEnrollmentStatus(boolean enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    
    public CourseOffering(Course course, FacultyProfile faculty, Schedule schedule, int capacity) {
        this.course = course;
        this.faculty = faculty;
        this.schedule = schedule;
        this.capacity = capacity;
    }
    
    
}
