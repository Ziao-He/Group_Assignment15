/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CourseDirectory {
    private ArrayList<CourseOffering> offer;

    public CourseDirectory() {
        offer = new ArrayList<>();
    }

    public ArrayList<CourseOffering> getCourseOfferingList() {
        return offer;
    }

    public CourseOffering findOfferingById(String courseId) {
        for (CourseOffering o : offer) {
            if (o.getCourse().getCourseId().equalsIgnoreCase(courseId)) {
                return o;
            }
        }
        return null;
    }

    public ArrayList<CourseOffering> findByFacultyName(String faculty) {
        ArrayList<CourseOffering> res = new ArrayList<>();
        for (CourseOffering o : offer) {
            if (o.getFaculty() != null && o.getFaculty().toLowerCase().contains(faculty.toLowerCase())) {
                res.add(o);
            }
        }
        return res;
    }

    public ArrayList<CourseOffering> findBySemester(String semester) {
        ArrayList<CourseOffering> res = new ArrayList<>();
        for (CourseOffering o : offer) {
            if (o.getSemester() != null && o.getSemester().toLowerCase().contains(semester.toLowerCase())) {
                res.add(o);
            }
        }
        return res;
    }

    public void addOffering(CourseOffering o) {
        offer.add(o);
    }
}   

