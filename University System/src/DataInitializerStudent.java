
import Business.Business;
import Business.Course.Course;
import Business.Course.CourseDirectory;
import Business.Course.CourseOffering;
import static java.time.Clock.system;
import static java.time.InstantSource.system;
import static javax.xml.catalog.CatalogManager.catalog;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class DataInitializerStudent {
    
    public static void initialize() {
        Business business = new Business("Student part");
        
        CourseDirectory coursedirectory = business.getCourseDirectory();
        // add class
        Course c1 = new Course("INFO 5100", "Application Engineering and Development", 4);
        Course c2 = new Course("CS 5200", "Algorithms", 3);
        Course c3 = new Course("DS 5300", "Data Science", 3);

        // add CourseOffering
        CourseOffering o1 = new CourseOffering(c1, "Dr. Smith", "Fall 2025", 30);
        CourseOffering o2 = new CourseOffering(c2, "Dr. Adams", "Fall 2025", 25);
        CourseOffering o3 = new CourseOffering(c3, "Dr. Brown", "Spring 2025", 25);

        // add to business
        coursedirectory.addOffering(o1);
        coursedirectory.addOffering(o2);
        coursedirectory.addOffering(o3);
    }    
}
