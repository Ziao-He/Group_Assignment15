/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paymenet;

import Business.Course.Course;
import Business.Course.CourseOffering;
import Business.Person.Student;
import java.util.Date;

/**
 *
 * @author Yiyang Lin
 */
public class PaymentRecord {
    private Date date;
    private double amout;
    private String description;
    private String status;
    private String courseID;
    
    public PaymentRecord(Date date,double amount,String description,String status,Course course){
        this.date = date;
        this.amout = amount;
        this.description = description;
        this.status = status;
        this.courseID = course.getCourseId();
    }
    
    public PaymentRecord(Date date,double amount,String description,String status){
        this.date = date;
        this.amout = amount;
        this.description = description;
        this.status = status;;
    }    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public Double getRecievePayment(CourseOffering co){
        if(co.getCourse().getCourseId().equals(this.getCourseID()) && status.equals("PAID")){
                return amout;
         }       
        return 0.0;
            
    }
    
}
