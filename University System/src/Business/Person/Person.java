/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String role;

    public Person(String role) {

        this.role= role;
    }

    public String getPersonRole() {
        return role;
    }

    public boolean isMatch(String role) {
        if (getPersonRole().equals(role)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getPersonRole();
    }
}
