/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author bob-h
 * Admin.java
 * Administrator class with built-in ID generation and validation
 * Properly inherits from Person base class
 */
public class Admin extends Person {
    // Static counter for auto-generating Admin IDs
    private static int adminCounter = 30001;
    
    // Admin-specific fields
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String adminID;
    private String department;
    
    /**
     * Constructor for Admin
     * Properly calls Person(role) constructor
     */
    public Admin(String firstName, String lastName, String email,String phone, String adminID) {
        super("Admin");  // Pass role to Person constructor - IMPORTANT!
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.adminID = adminID;
        this.department = "Administration";
    }
    
    /**
     * Constructor with custom department
     */
    public Admin(String firstName, String lastName, String email, String phone, String adminID, String department) {
        super("Admin");  // Pass role to Person constructor - IMPORTANT!
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.adminID = adminID;
        this.department = department != null ? department : "Administration";
    }
    
    /**
     * Auto-generate unique Admin ID
     */
    public static String generateAdminID() {
        return "ADM" + String.format("%05d", adminCounter++);
    }
    
    /**
     * Reset admin counter (useful for testing or data reload)
     */
    public static void setAdminCounter(int value) {
        if (value > 0) {
            adminCounter = value;
        }
    }
    
    /**
     * Get current counter value
     */
    public static int getAdminCounter() {
        return adminCounter;
    }
    
    /**
     * Validate email format
     * Accepts standard email formats like user@domain.com
     */
    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.trim().matches(emailRegex);
    }
    
    /**
     * Validate name (at least 2 characters, letters and spaces only)
     */
    public static boolean isValidName(String name) {
        if (isEmpty(name)) {
            return false;
        }
        String trimmed = name.trim();
        return trimmed.length() >= 2 && trimmed.matches("[a-zA-Z][a-zA-Z ]*");
    }
    
    /**
     * Validate phone number (must have exactly 10 digits)
     */
    public static boolean isValidPhone(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        return digitsOnly.length() == 10;
    }
    
    /**
     * Check if string is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Validate all required fields at once
     */
    public static String validateAllFields(String firstName, String lastName, String email, String phone) {
        if (!isValidName(firstName)) {
            return "Invalid first name! Must be at least 2 letters.";
        }
        if (!isValidName(lastName)) {
            return "Invalid last name! Must be at least 2 letters.";
        }
        if (!isValidEmail(email)) {
            return "Invalid email format! Example: user@university.edu";
        }
        if (!isValidPhone(phone)) {
            return "Invalid phone number! Must be 10 digits.";
        }
        return null;  // All valid
    }
    
    /**
     * Show error dialog
     */
    public static void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Show success dialog
     */
    public static void showSuccess(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,"Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Show warning dialog
     */
    public static void showWarning(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Show information dialog
     */
    public static void showInfo(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Show confirmation dialog
     */
    public static boolean showConfirmation(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    public String getAdminID() {
        return adminID;
    }
    
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        if (!isEmpty(firstName)) {
            this.firstName = firstName.trim();
        }
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        if (!isEmpty(lastName)) {
            this.lastName = lastName.trim();
        }
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (!isEmpty(email)) {
            this.email = email.trim();
        }
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        if (!isEmpty(phone)) {
            this.phone = phone.trim();
        }
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        if (!isEmpty(department)) {
            this.department = department.trim();
        }
    }
    
    /**
     * Update admin profile information
     * Only updates non-empty fields
     */
    public boolean updateProfile(String firstName, String lastName,String email, String phone) {
        boolean updated = false;
        
        if (!isEmpty(firstName) && isValidName(firstName)) {
            this.firstName = firstName.trim();
            updated = true;
        }
        if (!isEmpty(lastName) && isValidName(lastName)) {
            this.lastName = lastName.trim();
            updated = true;
        }
        if (!isEmpty(email) && isValidEmail(email)) {
            this.email = email.trim();
            updated = true;
        }
        if (!isEmpty(phone) && isValidPhone(phone)) {
            this.phone = phone.trim();
            updated = true;
        }
        
        return updated;
    }
    
    /**
     * Check if admin matches search criteria
     */
    public boolean matches(String searchTerm) {
        if (isEmpty(searchTerm)) {
            return false;
        }
        String term = searchTerm.toLowerCase().trim();
        return getFullName().toLowerCase().contains(term) ||
               adminID.toLowerCase().contains(term) ||
               email.toLowerCase().contains(term) ||
               department.toLowerCase().contains(term);
    }
    
    @Override
    public String getPersonRole() {
        return super.getPersonRole(); // Returns "Admin"
    }
}
