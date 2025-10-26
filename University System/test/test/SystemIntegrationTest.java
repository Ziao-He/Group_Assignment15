package test;

import Business.Business;
import Business.Course.Course;
import Business.Person.Admin;
import Business.Person.AdminDirectory;
import Business.Person.Person;
import Business.Person.Student;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;

import UserInterface.WorkAreas.StudentRole.StudentFranscriptDialog;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

/**
 * 综合系统测试类 - 包含业务逻辑、认证授权及GUI验证
 * 放置路径：University System/test/test/SystemIntegrationTest.java
 */
public class SystemIntegrationTest {

    private static Business business;
    private static StudentProfile studentProfile;
    private static UserAccount adminAccount;
    private static UserAccount studentAccount;

    @BeforeAll
    public static void setup() {
        business = new Business("NEU Business System");

        // 创建人员与账户
        Person studentPerson = business.getPersonDirectory().newPerson("Alice Johnson");
        
        Student s2 = new Student("0002", "Emma Johnson", "Student");
        s2.setEmail("emma.johnson@northeastern.edu");
        s2.setPhone("617-555-1002");
        s2.setDepartment("Computer Science");
        studentProfile = new StudentProfile(studentPerson,s2);

        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        
        AdminDirectory adminDirectory = business.getAdminDirectory();
        Admin admin1 = adminDirectory.newAdmin("John","Smith","john.smith@university.edu","617-555-0001");
        Person adminPerson = business.getPersonDirectory().newPerson("John Smith");
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(adminPerson, admin1);
        
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****");
        
        UserAccount ua4 = uadirectory.newUserAccount(s2, "adam", "****");
        studentAccount = uadirectory.createUserAccount("alice", "password", studentProfile, "Student");

        // 创建课程及成绩
        Course course1 = business.getCourseCatalog().newCourse("INFO5100", "AED", 4);
        Course course2 = business.getCourseCatalog().newCourse("INFO6200", "Web Tools", 3);

        CourseOffer offer1 = business.getCourseSchedule("Fall2025").newCourseOffer("INFO5100");
        CourseOffer offer2 = business.getCourseSchedule("Fall2025").newCourseOffer("INFO6200");

        studentProfile.getCourseLoadBySemester("Fall2025").registerForCourseOffer(offer1);
        studentProfile.getCourseLoadBySemester("Fall2025").registerForCourseOffer(offer2);

        studentProfile.getCourseLoadBySemester("Fall2025").addGrade("INFO5100", "A");
        studentProfile.getCourseLoadBySemester("Fall2025").addGrade("INFO6200", "B");
    }

    // =====================
    // 登录认证测试
    // =====================
    @Test
    @DisplayName("测试认证模块 - 管理员登录成功")
    public void testAuthenticationSuccess() {
        UserAccount ua = business.getUserAccountDirectory().authenticateUser("admin", "admin123");
        assertNotNull(ua, "管理员应能成功登录");
        assertEquals("Admin", ua.getRole(), "角色应为Admin");
    }

    @Test
    @DisplayName("测试认证模块 - 登录失败（错误密码）")
    public void testAuthenticationFail() {
        UserAccount ua = business.getUserAccountDirectory().authenticateUser("admin", "wrong");
        assertNull(ua, "应拒绝错误密码登录");
    }

    // =====================
    // 权限控制测试
    // =====================
    @Test
    @DisplayName("测试授权模块 - 学生无法访问管理员资源")
    public void testAuthorizationRestriction() {
        String role = studentAccount.getRole();
        boolean canAccessAdmin = role.equals("Admin");
        assertFalse(canAccessAdmin, "学生不应能访问管理员界面");
    }

    // =====================
    // 学术逻辑测试
    // =====================
    @Test
    @DisplayName("测试课程注册与成绩计算")
    public void testCourseAndGPA() {
        CourseLoad cl = studentProfile.getCourseLoadBySemester("Fall2025");
        double gpa = cl.calculateGPA();
        assertTrue(gpa > 0, "GPA应大于0");
        assertEquals(3.5, gpa, 0.1, "GPA应接近3.5");
    }

    @Test
    @DisplayName("测试学术状态判断")
    public void testAcademicStanding() {
        double gpa = studentProfile.getCourseLoadBySemester("Fall2025").calculateGPA();
        String standing = (gpa >= 2.0) ? "Good Standing" : "Academic Probation";
        assertEquals("Good Standing", standing, "GPA>=2应为Good Standing");
    }



    @AfterAll
    public static void tearDown() {
        business = null;
        studentProfile = null;
    }
}
