/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.Course;

/**
 *
 * @author Administrator
 */
public class CourseWork {
    private Course course;        
    private String title; 
    
    public CourseWork(Course course, String title) {
        this.course = course;
        this.title = title;
    }    

    public Course getCourse() {
        return course;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
