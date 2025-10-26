/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.CourseOffering;
import java.util.ArrayList;

/**
 *
 * @author Yiyang Lin
 */
public class StudentDirectory {
    private ArrayList<Student> studentList = new ArrayList<>();

    public Student addStudent(Student s){
        studentList.add(s);
        return s;
    }

    public Student findStudentById(String id){
        for (Student s : studentList){
            if (s.getStudentId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    public ArrayList<Student> getStudentList(){
        return studentList;
    }  
    
    public ArrayList<Student> findEnrollStudent(CourseOffering courseOffering){
        ArrayList<Student> sList = new ArrayList<>();
        String facultyname = courseOffering.getFaculty().getFacultyName();
        String coursename = courseOffering.getCourse().getName();
        String StartTime = courseOffering.getSchedule().getStartTime();
        for (Student s : studentList){   
            for(CourseOffering co: s.getEnrolledOfferings())
                if (co.getFaculty().getFacultyName().equals(facultyname) && co.getCourse().getName().equals(coursename) && co.getSchedule().getStartTime().equals(StartTime)) 
                    sList.add(s);
        }
        if (!sList.isEmpty())
            return sList;
        else
            return null;
    }
}
