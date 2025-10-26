/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

/**
 *
 * @author Administrator
 */
public class CourseGrade {
    private Course course;
    private String term; 
    private String grade= "F";
    private double gpa = 0.00;

    public CourseGrade(Course course, String term, String grade, double gpa){
        this.course = course;
        this.term = term;
        this.grade = grade;
        this.gpa = gpa;
    }
    
       public CourseGrade(Course course, String term){
        this.course = course;
        this.term = term;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public String getLetterGrade(double gpa) {
        if (gpa >= 3.8) return "A";
        else if (gpa >= 3.7) return "A-";
        else if (gpa >= 3.3) return "B+";
        else if (gpa >= 3.0) return "B";
        else if (gpa >= 2.7) return "B-";
        else if (gpa >= 2.3) return "C+";
        else if (gpa >= 2.0) return "C";
        else if (gpa >= 1.7) return "C-";
        else if (gpa >= 1.3) return "D+";
        else if (gpa >= 1.0) return "D";
        else return "F";
    }

    
    public double getGradePoint(){
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
    
    public double getGpaByCourse(Course c){
        if(c.getName().equals(this.course.getName()))
            return gpa;
        return -1;
    }
    
    public String getGradeLetterByCourse(Course c){
        if(c.getName().equals(this.course.getName()))
            return getGrade();
        return "";
    }
}
