/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import Business.Person.Student;
import Business.Person.StudentDirectory;

/**
 *
 * @author Yiyang Lin
 */
public class StudentProfile extends Profile {

    Person person;
    Student student;
//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;

    public StudentProfile(Person p,Student s) {
        super(p);
        this.student =s;

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    public Person getPerson() {
        return person;
    }

    public Student getStudent() {
        return student;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return person.getPersonRole().equals(id);
    }
    
    public void updateStudentData(StudentDirectory directory){
        Student original =directory.findStudentById(student.getStudentId());
        if(original !=null){
            original = student;
        }
    }
}
