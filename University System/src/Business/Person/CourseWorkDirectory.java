/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Course.Course;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CourseWorkDirectory {
    private ArrayList<CourseWork> courseWorkDirectory;

    public CourseWorkDirectory() {
        courseWorkDirectory = new ArrayList<>();
    }    

    public ArrayList<CourseWork> getCourseWorkDirectory() {
        return courseWorkDirectory;
    }
    
    public CourseWork addCourseWork(Course course, String title) {
        CourseWork cw = new CourseWork(course, title);
        courseWorkDirectory.add(cw);
        return cw;
    }  
    
    public CourseWork findCourseWorkByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }

        for (CourseWork cw : courseWorkDirectory) {
            if (cw.getTitle() != null && cw.getTitle().equalsIgnoreCase(title)) {
                return cw;
            }
        }

        return null; 
    }
}
