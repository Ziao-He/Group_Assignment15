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
        Person person001 = persondirectory.newPerson("Alice Johnson");
        Person person002 = persondirectory.newPerson("Bob Smith");
        Person person003 = persondirectory.newPerson("Cyrus Brown");
        Person person004 = persondirectory.newPerson("Diana Taylor");
        Person person005 = persondirectory.newPerson("Evan Lee");
        Person person006 = persondirectory.newPerson("Fiona Wilson");
        Person person007 = persondirectory.newPerson("George Clark");
        Person person008 = persondirectory.newPerson("Hannah Hall");
        Person person009 = persondirectory.newPerson("Ian Adams");
        Person person010 = persondirectory.newPerson("Jane King");
        Person person011 = persondirectory.newPerson("Kevin Wright");
        Person person012 = persondirectory.newPerson("Laura Green");
        Person person013 = persondirectory.newPerson("Mike Harris");
        Person person014 = persondirectory.newPerson("Nina Lewis");
        Person person015 = persondirectory.newPerson("Oscar Roberts");
        Person person016 = persondirectory.newPerson("Paula Walker");
        Person person017 = persondirectory.newPerson("Quinn Young");
        Person person018 = persondirectory.newPerson("Rachel Allen");
        Person person019 = persondirectory.newPerson("Steve Scott");
        Person person020 = persondirectory.newPerson("Tina Hill");
        Person person021 = persondirectory.newPerson("Victor Martin");
        Person person022 = persondirectory.newPerson("Wendy Moore");
        Person person023 = persondirectory.newPerson("Xavier Clark");
        Person person024 = persondirectory.newPerson("Yolanda Baker");
        Person person025 = persondirectory.newPerson("Zachary Hall");
        Person person026 = persondirectory.newPerson("Amber Collins");
        Person person027 = persondirectory.newPerson("Brian Foster");
        Person person028 = persondirectory.newPerson("Chloe Simmons");
        Person person029 = persondirectory.newPerson("David Turner");
        Person person030 = persondirectory.newPerson("Emily Morgan");

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
        
        Student s6 =new Student("0006", "Linyiyang", "Student");
        s6.setEmail("lin.yiyang@northeastern.edu");
        s6.setPhone("617-535-1045");
        s6.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s6);
        
        StudentProfile sD6 = new StudentProfile(s6, s6);
        sPD.newStudentProfile(sD6);
        
        Student s7 =new Student("0007", "Liang yujie", "Student");
        s7.setEmail("Liang.yujie@northeastern.edu");
        s7.setPhone("517-535-1445");
        s7.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s7);
        
        StudentProfile sD7 = new StudentProfile(s7, s7);
        sPD.newStudentProfile(sD7);
        
        Student s8 =new Student("0008", "Tim oven", "Student");
        s8.setEmail("Tim.owven@northeastern.edu");
        s8.setPhone("817-538-2445");
        s8.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s8);
        
        StudentProfile sD8 = new StudentProfile(s8, s8);
        sPD.newStudentProfile(sD8);
        
        Student s9 =new Student("0009", "Jerry heavy", "Student");
        s9.setEmail("jerry.heavy@northeastern.edu");
        s9.setPhone("217-545-9445");
        s9.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s9);
        
        StudentProfile sD9 = new StudentProfile(s9, s9);
        sPD.newStudentProfile(sD9);
        
        Student s10 =new Student("0010", "Curry tim", "Student");
        s10.setEmail("Curry.tim@northeastern.edu");
        s10.setPhone("517-935-7863");
        s10.setDepartment("Computer Science");
        business.getStudentDirectory().addStudent(s10);
        
        StudentProfile sD10 = new StudentProfile(s10, s10);
        sPD.newStudentProfile(sD10);
        

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
        FacultyProfile faprofile5 =fadirectory.newFacultyDirectory(person015);
        faprofile5.setFacultyId("0006");
        faprofile5.setEmail("steven@northeastern.edu");
        faprofile5.setPhone("617-515-2405");
        faprofile5.setDepartment("Computer Science");
        FacultyProfile faprofile6 =fadirectory.newFacultyDirectory(person016);
        faprofile6.setFacultyId("0007");
        faprofile6.setEmail("person16@northeastern.edu");
        faprofile6.setPhone("617-656-2305");
        faprofile6.setDepartment("Computer Science");
        FacultyProfile faprofile7 =fadirectory.newFacultyDirectory(person017);
        faprofile7.setFacultyId("0008");
        faprofile7.setEmail("person17@northeastern.edu");
        faprofile7.setPhone("917-156-2307");
        faprofile7.setDepartment("Computer Science");
        FacultyProfile faprofile8 =fadirectory.newFacultyDirectory(person018);
        faprofile8.setFacultyId("0009");
        faprofile8.setEmail("person18@northeastern.edu");
        faprofile8.setPhone("917-651-9305");
        faprofile8.setDepartment("Computer Science");
        FacultyProfile faprofile9 =fadirectory.newFacultyDirectory(person019);
        faprofile9.setFacultyId("0010");
        faprofile9.setEmail("person19@northeastern.edu");
        faprofile9.setPhone("157-256-9305");
        faprofile9.setDepartment("Computer Science");

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
        CourseOffering o1 = new CourseOffering(c1, faprofile1, sch1, 300);
        CourseOffering o2 = new CourseOffering(c2, faprofile1, sch2, 250);
        CourseOffering o3 = new CourseOffering(c3, faprofile2, sch3, 250);
        CourseOffering o4 = new CourseOffering(c3, faprofile3, sch4, 250);
        CourseOffering o5 = new CourseOffering(c4, faprofile4, sch5, 250);
        CourseOffering o6 = new CourseOffering(c5, faprofile5, sch6, 250);
        
        // add to business
        coursedirectory.addOffering(o1);
        coursedirectory.addOffering(o2);
        coursedirectory.addOffering(o3);    
        coursedirectory.addOffering(o4);
        coursedirectory.addOffering(o5);
        coursedirectory.addOffering(o6);
        
        sD1.getStudent().enrollCourse(o1);
        sD2.getStudent().enrollCourse(o1);
        sD3.getStudent().enrollCourse(o1);

        
        //create course work
        CourseWorkDirectory CourseWorkdirectory = business.getCourseWorkDirectory();
        CourseWorkdirectory.addCourseWork(c1, "Lab 01");
        CourseWorkdirectory.addCourseWork(c1, "Lab 02");
        CourseWorkdirectory.addCourseWork(c1, "Lab 03");
        CourseWorkdirectory.addCourseWork(c1, "Lab 04");
        CourseWorkdirectory.addCourseWork(c1, "Lab 05");
        CourseWorkdirectory.addCourseWork(c1, "Lab 06");
        CourseWorkdirectory.addCourseWork(c1, "Lab 07");
        CourseWorkdirectory.addCourseWork(c1, "Lab 08");
        CourseWorkdirectory.addCourseWork(c1, "Lab 09");
        CourseWorkdirectory.addCourseWork(c1, "Lab 10");

        
//        sD1.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(0), "This is Lab 01 report");
//        sD1.getStudent().submitAssignment(CourseWorkdirectory.getCourseWorkDirectory().get(1), "This is Lab 02 report");
        
//        sD1.getStudent().addCourseGrade(c1, "Fall 2025","B",3.1);
            sD1.getStudent().payTuition(1200);
        
//        sD2.getStudent().addCourseGrade(c1, "Fall 2025","A",3.8);
//        sD3.getStudent().addCourseGrade(c1, "Fall 2025","B+",3.5);
//        
//        sD4.getStudent().addCourseGrade(c3, "Spring 2025","B+",3.5);
        //添加Registrar账户
        UserAccount uaRegistrar = uadirectory.newUserAccount(registrarProfile, "Registrar", "****");
        return business;

    }
}