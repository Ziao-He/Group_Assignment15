/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Course.CourseOffering;
import Business.Person.CourseWork;
import Business.Person.CourseWorkDirectory;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Person.Student;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentProfileDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
 
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");
        Person person009 = persondirectory.newPerson("Fidelity"); //we use this as customer

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
//        StudentProfileDirectory studentdirectory = business.getStudentDirectory();
//        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        Student s1 = new Student("0001","Lin Yiyang","Student");
        business.getStudentDirectory().addStudent(s1);
        
        StudentProfile sD =new StudentProfile(s1,s1);
        

        // Create User accounts that link to specific profiles
        FacultyDirectory fadirectory = business.getFacultyDirectory(); 
        FacultyProfile faprofile0 =fadirectory.newFacultyDirectory(person002);
        
 


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(sD, "adam", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount fua =uadirectory.newUserAccount(faprofile0, "fua", "****");
        
        CourseDirectory coursedirectory = business.getCourseDirectory();
    
        Course c1 = new Course("INFO 5100", "Application Engineering and Development", 4);
        Course c2 = new Course("CS 5200", "Algorithms", 12);
        Course c3 = new Course("DS 5300", "Data Science", 6);
        Course c4 = new Course("DS 5500", "Infomation Science", 14);
        Course c5 = new Course("DS 5600", "Computer Science", 28);

        // add CourseOffering
        CourseOffering o1 = new CourseOffering(c1, "Lin", "Fall 2025", 30);
        CourseOffering o2 = new CourseOffering(c2, "Dr. Adams", "Fall 2025", 25);
        CourseOffering o3 = new CourseOffering(c3, "Dr. Brown", "Spring 2025", 25);
        CourseOffering o4 = new CourseOffering(c3, "Dr. Brown", "Fall 2025", 25);
        CourseOffering o5 = new CourseOffering(c4, "Dr. Adams", "Fall 2025", 25);
        CourseOffering o6 = new CourseOffering(c5, "Dr. Brown", "Fall 2025", 25);
        
        // add to business
        coursedirectory.addOffering(o1);
        coursedirectory.addOffering(o2);
        coursedirectory.addOffering(o3);    
        coursedirectory.addOffering(o4);
        coursedirectory.addOffering(o5);
        coursedirectory.addOffering(o6);
        
        sD.getStudent().enrollCourse(new CourseOffering(c1,"Lu qiang","Fall 2025",30));
        sD.getStudent().payTuition(-9000);
        
        //create course work
        CourseWorkDirectory CourseWorkdirectory = business.getCourseWorkDirectory();
        CourseWorkdirectory.addCourseWork(c1, "Lab 01");
        CourseWorkdirectory.addCourseWork(c1, "Lab 02");
        
        sD.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(0), "This is Lab 01 report");
        
        //add CourseGrade
        sD.getStudent().addCourseGrade(c1, "Fall 2025","B");
        
        return business;

    }

}
