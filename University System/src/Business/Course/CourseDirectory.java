/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import java.util.ArrayList;

/**
 *
 * @author Yiyang Lin and Yujie Liang
 */
public class CourseDirectory {
    private ArrayList<CourseOffering> offerList;

    public CourseDirectory() {
        offerList = new ArrayList<>();
    }

    public ArrayList<CourseOffering> getCourseOfferingList() {
        return offerList;
    }



    public ArrayList<CourseOffering> findOfferingById(String courseId) {
        ArrayList<CourseOffering> res = new ArrayList<>();
        String cleanFaculty = courseId.replaceAll("[\\p{P}\\p{S}]", "");
        for (CourseOffering o : offerList) {
                String cleanCourseFaculty = o.getCourse().getCourseId().replaceAll("[\\p{P}\\p{S}]", ""); 
                if (cleanCourseFaculty != null && cleanCourseFaculty.toLowerCase().contains(cleanFaculty.toLowerCase())) {
                res.add(o);
                }
        }
        return res;
    }

    public ArrayList<CourseOffering> findByFacultyName(String faculty) {
        ArrayList<CourseOffering> res = new ArrayList<>();
        String cleanFaculty = faculty.replaceAll("[\\p{P}\\p{S}]", "");
        for (CourseOffering o : offerList) {
                String cleanCourseFaculty = o.getFaculty().getFacultyName().replaceAll("[\\p{P}\\p{S}]", ""); 
                if (cleanCourseFaculty != null && cleanCourseFaculty.toLowerCase().contains(cleanFaculty.toLowerCase())) {
                res.add(o);
                }
        }
        if(!res.isEmpty())
            return res;
        else
            return null;
    }

    public ArrayList<CourseOffering> findBySemester(String semester) {
        ArrayList<CourseOffering> res = new ArrayList<>();
        for (CourseOffering o : offerList) {
            if (o.getSemester() != null && o.getSemester().toLowerCase().contains(semester.toLowerCase())) {
                res.add(o);
            }
        }
        return res;
    }

    public void addOffering(CourseOffering o) {
        offerList.add(o);
    }
}   

