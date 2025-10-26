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
import Business.Person.Admin;
import Business.Person.AdminDirectory;
import Business.Person.CourseWork;
import Business.Person.CourseWorkDirectory;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Person.Student;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.RegistrarDirectory;
import Business.Profiles.RegistrarProfile;
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
        Person person014 = persondirectory.newPerson("Registrar Cryus");

// Create Admins to manage the business
        AdminDirectory adminDirectory = business.getAdminDirectory();
        Admin admin1 = adminDirectory.newAdmin("John","Smith","john.smith@university.edu","617-555-0001");
        Person adminPerson = persondirectory.newPerson("John Smith");
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(adminPerson, admin1);
        
//        StudentProfileDirectory studentdirectory = business.getStudentDirectory();
//        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        Student s1 = new Student("0001", "Lin Yiyang", "Student");
        s1.setEmail("lin.yiyang@northeastern.edu");
        s1.setPhone("617-555-1001");
        s1.setDepartment("Information Systems");
        business.getStudentDirectory().addStudent(s1);

        StudentProfile sD1 = new StudentProfile(s1, s1);
        StudentProfileDirectory sPD = business.getStudentProfileDirectory();
        sPD.newStudentProfile(sD1);
        
        Student s2 = new Student("0002", "Emma Johnson", "Student");
        s2.setEmail("emma.johnson@northeastern.edu");
        s2.setPhone("617-555-1002");
        s2.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s2);

        StudentProfile sD2 = new StudentProfile(s2, s2);
        sPD.newStudentProfile(sD2);
        
        Student s3 = new Student("0003", "Michael Chen", "Student");
        s3.setEmail("michael.chen@northeastern.edu");
        s3.setPhone("617-555-1003");
        s3.setDepartment("Data Science");
        business.getStudentDirectory().addStudent(s3);

        StudentProfile sD3 = new StudentProfile(s3, s3);
        sPD.newStudentProfile(sD3);
        
        Student s4 = new Student("0004", "Sarah Williams", "Student");
        s4.setEmail("sarah.williams@northeastern.edu");
        s4.setPhone("617-555-1004");
        s4.setDepartment("Information Systems");
        business.getStudentDirectory().addStudent(s4);

        StudentProfile sD4 = new StudentProfile(s4, s4);
        sPD.newStudentProfile(sD4);
        
        Student s5 = new Student("0005", "David Martinez", "Student");
        s5.setEmail("david.martinez@northeastern.edu");
        s5.setPhone("617-555-1005");
        s5.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s5);

        StudentProfile sD5 = new StudentProfile(s5, s5);
        sPD.newStudentProfile(sD5);
        

        // Create User accounts that link to specific profiles
        FacultyDirectory fadirectory = business.getFacultyDirectory(); 
        FacultyProfile faprofile0 =fadirectory.newFacultyDirectory(person002);
        faprofile0.setFacultyId("0001");
        faprofile0.setEmail("gina.montana@northeastern.edu");
        faprofile0.setPhone("617-555-2001");
        faprofile0.setDepartment("Information Systems");
        FacultyProfile faprofile1 =fadirectory.newFacultyDirectory(person010);
        faprofile1.setFacultyId("0002");
        faprofile1.setEmail("lin@northeastern.edu");
        faprofile1.setPhone("617-555-2002");
        faprofile1.setDepartment("Computer Science");
        FacultyProfile faprofile2 =fadirectory.newFacultyDirectory(person011);
        faprofile2.setFacultyId("0003");
        faprofile2.setEmail("dr.adams@northeastern.edu");
        faprofile2.setPhone("617-555-2003");
        faprofile2.setDepartment("Data Science");
        FacultyProfile faprofile3 =fadirectory.newFacultyDirectory(person012);
        faprofile3.setFacultyId("0004");
        faprofile3.setEmail("dr.brown@northeastern.edu");
        faprofile3.setPhone("617-555-2004");
        faprofile3.setDepartment("Information Systems");
        FacultyProfile faprofile4 =fadirectory.newFacultyDirectory(person013);
        faprofile4.setFacultyId("0005");
        faprofile4.setEmail("lu.qiang@northeastern.edu");
        faprofile4.setPhone("617-555-2005");
        faprofile4.setDepartment("Computer Science");

        //添加Registrar
        RegistrarDirectory registrarDirectory = business.getRegistrarDirectory();
        RegistrarProfile registrarProfile = registrarDirectory.newRegistrarProfile(
            person010, 
            "REG001", 
            "registrar@university.edu", 
            "123-456-7890", 
            "Mon-Fri 9:00-17:00", 
            "Admin Building Room 101"
        );
        
        

       
 


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(sD1, "adam", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount fua = uadirectory.newUserAccount(faprofile0, "fua", "****");
        UserAccount f = uadirectory.newUserAccount(faprofile1, "f", "****");
        
        CourseDirectory coursedirectory = business.getCourseDirectory();
    
        Course c1 = new Course("INFO 5100", "Application Engineering and Development", 4);
        Course c2 = new Course("CS 5200", "Algorithms", 4);
        Course c3 = new Course("DS 5300", "Data Science", 4);
        Course c4 = new Course("DS 5500", "Infomation Science", 4);
        Course c5 = new Course("DS 5600", "Computer Science", 4);
        
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
        CourseOffering o3 = new CourseOffering(c3, faprofile3, sch3, 25);
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
        
        sD1.getStudent().enrollCourse(new CourseOffering(c1,faprofile1,sch1,30));
        sD2.getStudent().enrollCourse(new CourseOffering(c1,faprofile1,sch1,30));
        sD3.getStudent().enrollCourse(new CourseOffering(c1,faprofile1,sch1,30));
        sD4.getStudent().enrollCourse(new CourseOffering(c3,faprofile1,sch3,25));
        
        //create course work
        CourseWorkDirectory CourseWorkdirectory = business.getCourseWorkDirectory();
        CourseWorkdirectory.addCourseWork(c1, "Lab 01");
        CourseWorkdirectory.addCourseWork(c1, "Lab 02");
        CourseWorkdirectory.addCourseWork(c2, "Lab 03");
        
        sD1.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(0), "This is Lab 01 report");
        sD1.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(1), "This is Lab 02 report");
        
//        sD1.getStudent().addCourseGrade(c1, "Fall 2025","B",3.1);
        sD1.getStudent().payTuition(1200);
        
        sD2.getStudent().addCourseGrade(c1, "Fall 2025","A",3.8);
        sD3.getStudent().addCourseGrade(c1, "Fall 2025","B+",3.5);
        
        sD4.getStudent().addCourseGrade(c3, "Spring 2025","B+",3.5);
        //添加Registrar账户
        UserAccount uaRegistrar = uadirectory.newUserAccount(registrarProfile, "Registrar", "****");
        return business;

    }
}