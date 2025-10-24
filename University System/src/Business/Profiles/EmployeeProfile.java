/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Admin;
import Business.Person.AdminDirectory;
import Business.Person.Person;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile extends Profile {

    Person user; 
    Admin admin; 
    
    /**
     * Constructor with Person and Admin
     * Follows StudentProfile pattern
     */
    public EmployeeProfile(Person p, Admin a) {
        super(p);           // Pass Person to parent Profile class
        this.user = p;
        this.admin = a;
    }
    
    public EmployeeProfile(Person p) {
        super(p);
        this.user = p;
        this.admin = null;  // No associated Admin
    }
    
    public Person getPerson() {
        return user;
    }
    
    public Admin getAdmin() {
        return admin;
    }
    
    public void setPerson(Person person) {
        this.user = person;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    @Override
    public String getRole(){
        return  "Admin";
    }
}