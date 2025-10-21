/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class FacultyDirectory {
    private ArrayList<FacultyProfile> facultylist;

    public FacultyDirectory() {

     facultylist = new ArrayList();

    }

    public FacultyProfile newFacultyDirectory(Person p) {

        FacultyProfile sp = new FacultyProfile(p);
        facultylist.add(sp);
        return sp;
    }

//    public FacultyDirectory findStudent(String id) {
//
//        for (FacultyProfile sp : facultylist) {
//
//            if (sp.isMatch(id)) {
//                return sp;
//            }
//        }
//            return null; //not found after going through the whole list
//         }

    public ArrayList<FacultyProfile> getFacultylist() {
        return facultylist;
    }
}
