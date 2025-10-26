/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Course.CourseOffering;
import Business.Course.Schedule;
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
        
        Person person010 = persondirectory.newPerson("Lin");
        Person person011 = persondirectory.newPerson("Dr. Adams");
        Person person012 = persondirectory.newPerson("Dr. Brown");
        Person person013 = persondirectory.newPerson("Lu qiang");

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
//        StudentProfileDirectory studentdirectory = business.getStudentDirectory();
//        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        Student s1 = new Student("0001","Lin Yiyang","Student");
        business.getStudentDirectory().addStudent(s1);
        
        Student s2 = new Student("0002","Liang Yujie","Student");
        business.getStudentDirectory().addStudent(s2);
        
        Student s3 = new Student("0003","He Ziao","Student");
        business.getStudentDirectory().addStudent(s3);
        
        Student s4 = new Student("0004","Li Liyun","Student");
        business.getStudentDirectory().addStudent(s4);
        
        StudentProfile sD =new StudentProfile(s1,s1);
        StudentProfile sD2 =new StudentProfile(s2,s2);
        StudentProfile sD3 =new StudentProfile(s3,s3);
        StudentProfile sD4 =new StudentProfile(s4,s4);
        

        // Create User accounts that link to specific profiles
        FacultyDirectory fadirectory = business.getFacultyDirectory(); 
        FacultyProfile faprofile0 =fadirectory.newFacultyDirectory(person002);
        FacultyProfile faprofile1 =fadirectory.newFacultyDirectory(person010);
        FacultyProfile faprofile2 =fadirectory.newFacultyDirectory(person011);
        FacultyProfile faprofile3 =fadirectory.newFacultyDirectory(person012);
        FacultyProfile faprofile4 =fadirectory.newFacultyDirectory(person013);
        
        
 


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(sD, "adam", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount fua =uadirectory.newUserAccount(faprofile3, "fua", "****");
        
        UserAccount f =uadirectory.newUserAccount(faprofile1, "f", "****");
        
        CourseDirectory coursedirectory = business.getCourseDirectory();
    
        Course c1 = new Course("INFO 5100", "Application Engineering and Development", 4);
        Course c2 = new Course("CS 5200", "Algorithms", 12);
        Course c3 = new Course("DS 5300", "Data Science", 6);
        Course c4 = new Course("DS 5500", "Infomation Science", 14);
        Course c5 = new Course("DS 5600", "Computer Science", 28);
        
        //add Schedule
        Schedule sch1 = new Schedule("Fall 2025", "9:00AM", "10:30AM", "Ell Hall 103");
        Schedule sch2 = new Schedule("Fall 2025", "1:00PM", "4:00PM", "Ell Hall 203");
        Schedule sch3 = new Schedule("Spring 2025", "9:00AM", "10:30AM", "Churchill Hall 210");
        Schedule sch4 = new Schedule("Fall 2025", "6:00PM", "9:00PM", "Churchill Hall 103");
        Schedule sch5 = new Schedule("Fall 2025", "10:00AM", "12:30PM", "Shillman Hall 503");
        Schedule sch6 = new Schedule("Fall 2025", "9:00AM", "10:30AM", "Shillman Hall 313");
        Schedule sch7 = new Schedule("Fall 2025", "3:00PM", "5:30PM", "Ell Hall 601");

        // add CourseOffering
        CourseOffering o1 = new CourseOffering(c1, faprofile1, sch1, 30);
        CourseOffering o2 = new CourseOffering(c2, faprofile2, sch2, 25);
        CourseOffering o3 = new CourseOffering(c3, faprofile1, sch3, 25);
        CourseOffering o4 = new CourseOffering(c3, faprofile3, sch4, 25);
        CourseOffering o5 = new CourseOffering(c4, faprofile2, sch5, 25);
        CourseOffering o6 = new CourseOffering(c5, faprofile3, sch6, 25);

        
        // add to business
        coursedirectory.addOffering(o1);
        coursedirectory.addOffering(o2);
        coursedirectory.addOffering(o3);    
        coursedirectory.addOffering(o4);
        coursedirectory.addOffering(o5);
        coursedirectory.addOffering(o6);
        
        sD.getStudent().enrollCourse(new CourseOffering(c1,faprofile1,sch1,30));
        sD2.getStudent().enrollCourse(new CourseOffering(c1,faprofile1,sch1,30));
        sD3.getStudent().enrollCourse(new CourseOffering(c1,faprofile1,sch1,30));
        
        sD4.getStudent().enrollCourse(new CourseOffering(c3,faprofile1,sch3,25));


        
        //create course work
        CourseWorkDirectory CourseWorkdirectory = business.getCourseWorkDirectory();
        CourseWorkdirectory.addCourseWork(c1, "Lab 01");
        CourseWorkdirectory.addCourseWork(c1, "Lab 02");
        
        sD.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(0), "This is Lab 01 report");
        sD.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(1), "This is Lab 02 report");
        
        //add CourseGrade
        sD.getStudent().addCourseGrade(c1, "Fall 2025","B",3.1);
        sD.getStudent().payTuition(1200);
        
        sD2.getStudent().addCourseGrade(c1, "Fall 2025","A",3.8);
        sD3.getStudent().addCourseGrade(c1, "Fall 2025","B+",3.5);
        
        sD4.getStudent().addCourseGrade(c3, "Spring 2025","B+",3.5);
        
        return business;

    }

}
