/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author Yiyang Lin
 */
public class StudentProfileDirectory {


    ArrayList<StudentProfile> studentlist;

    public StudentProfileDirectory() {

     studentlist = new ArrayList();

    }

    public StudentProfile newStudentProfile(StudentProfile profile) {
        if(profile !=null && studentlist.contains((profile))){
            studentlist.add(profile);
        }
        return profile;
    }

    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
