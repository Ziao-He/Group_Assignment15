/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
 * @author Administrator
 */
public class FacultyProfile extends Profile{
    private String facultyId;
    private String email;
    private String Phone; 
    private String department; 
    
    public FacultyProfile(Person p){
        super(p);
    }

    public FacultyProfile(String facultyId, String email, String Phone, Person p) {
        super(p);
        this.facultyId = facultyId;
        this.email = email;
        this.Phone = Phone;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getFacultyName() {
        return this.getPerson().getPersonRole();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getRole() {
        return "Faculty";
    }
}
