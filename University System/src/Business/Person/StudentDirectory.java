/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Administrator
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
}
