/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Course.CourseDirectory;
import Business.Person.CourseWorkDirectory;
import Business.Person.PersonDirectory;
import Business.Person.StudentDirectory;
import Business.Person.AdminDirectory; 
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.RegistrarDirectory;
import Business.Profiles.StudentProfileDirectory;

import Business.UserAccounts.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role
    CourseDirectory courseDirectory;
    EmployeeDirectory employeedirectory;
    UserAccountDirectory useraccountdirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    CourseWorkDirectory courseWorkDirectory;
    AdminDirectory adminDirectory; 
    StudentProfileDirectory studentProfileDirectory;
    RegistrarDirectory registrardirectory;


    public Business(String n) {
        name = n;

        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        studentdirectory = new StudentDirectory();
        facultydirectory =new FacultyDirectory();
        courseDirectory = new CourseDirectory();
        courseWorkDirectory =new CourseWorkDirectory();
        adminDirectory = new AdminDirectory();
        studentProfileDirectory = new StudentProfileDirectory();
        registrardirectory = new RegistrarDirectory();
    }

    public CourseWorkDirectory getCourseWorkDirectory() {
        return courseWorkDirectory;
    }

    public CourseDirectory getCourseDirectory() {
        return courseDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }


    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public StudentDirectory getStudentDirectory(){
        return studentdirectory;
    }
    
    public FacultyDirectory getFacultyDirectory(){
        return facultydirectory;
    }
    
    public AdminDirectory getAdminDirectory() {
        return adminDirectory;
    }
    
    public StudentProfileDirectory getStudentProfileDirectory(){
        return studentProfileDirectory;
    }
    public RegistrarDirectory getRegistrarDirectory() {
        return registrardirectory;
    }
}
