/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bob-h
 * AdminDirectory manages all Admin objects in the system
 * Provides CRUD operations, duplicate checking, and search methods
 */
public class AdminDirectory {
    private ArrayList<Admin> adminList;
    
    public AdminDirectory() {
        this.adminList = new ArrayList<>();
    }
    
    /**
     * Create and add a new Admin with auto-generated ID
     * Performs duplicate checking before adding
     */
    public Admin newAdmin(String firstName, String lastName,String email, String phone) {
        // Check for duplicate email
        if (isDuplicateEmail(email)) {
            System.err.println("ERROR: Email already exists: " + email);
            return null;
        }
        
        // Generate unique ID
        String adminID = Admin.generateAdminID();
        
        // Create new admin
        Admin admin = new Admin(firstName, lastName, email, phone, adminID);
        adminList.add(admin);
        
        System.out.println("Admin created: " + admin);
        return admin;
    }
    
    /**
     * Add an existing Admin object
     */
    public boolean addAdmin(Admin admin) {
        if (admin == null) {
            return false;
        }
        
        // Check for duplicates
        if (isDuplicateAdminID(admin.getAdminID())) {
            System.err.println("ERROR: Admin ID already exists: " + admin.getAdminID());
            return false;
        }
        
        if (isDuplicateEmail(admin.getEmail())) {
            System.err.println("ERROR: Email already exists: " + admin.getEmail());
            return false;
        }
        
        adminList.add(admin);
        System.out.println("Admin added: " + admin);
        return true;
    }
    
    /**
     * Check if email already exists in the directory
     */
    public boolean isDuplicateEmail(String email) {
        if (Admin.isEmpty(email)) {
            return false;
        }
        
        String emailLower = email.trim().toLowerCase();
        for (Admin admin : adminList) {
            if (admin.getEmail().toLowerCase().equals(emailLower)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if Admin ID already exists
     */
    public boolean isDuplicateAdminID(String adminID) {
        if (Admin.isEmpty(adminID)) {
            return false;
        }
        
        String idUpper = adminID.trim().toUpperCase();
        for (Admin admin : adminList) {
            if (admin.getAdminID().toUpperCase().equals(idUpper)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Search admins by name (first name or last name)
     */
    public List<Admin> searchByName(String name) {
        List<Admin> results = new ArrayList<>();
        
        if (Admin.isEmpty(name)) {
            return results;
        }
        
        String searchTerm = name.toLowerCase().trim();
        
        for (Admin admin : adminList) {
            String fullName = admin.getFullName().toLowerCase();
            String firstName = admin.getFirstName().toLowerCase();
            String lastName = admin.getLastName().toLowerCase();
            
            if (fullName.contains(searchTerm) || 
                (firstName.contains(searchTerm) && 
                lastName.contains(searchTerm))) {
                results.add(admin);
            }
        }
        
        return results;
    }
    
    /**
     * Search admins by ID
     */
    public List<Admin> searchByID(String adminID) {
        List<Admin> results = new ArrayList<>();
        
        if (Admin.isEmpty(adminID)) {
            return results;
        }
        
        String searchTerm = adminID.toUpperCase().trim();
        
        for (Admin admin : adminList) {
            if (admin.getAdminID().toUpperCase().contains(searchTerm)) {
                results.add(admin);
            }
        }
        
        return results;
    }
    
    /**
     * Search admins by email
     */
    public List<Admin> searchByEmail(String email) {
        List<Admin> results = new ArrayList<>();
        
        if (Admin.isEmpty(email)) {
            return results;
        }
        
        String searchTerm = email.toLowerCase().trim();
        
        for (Admin admin : adminList) {
            if (admin.getEmail().toLowerCase().contains(searchTerm)) {
                results.add(admin);
            }
        }
        
        return results;
    }
    
    /**
     * Find exact admin by ID
     */
    public Admin findAdminByID(String adminID) {
        if (Admin.isEmpty(adminID)) {
            return null;
        }
        
        String idUpper = adminID.toUpperCase().trim();
        
        for (Admin admin : adminList) {
            if (admin.getAdminID().toUpperCase().equals(idUpper)) {
                return admin;
            }
        }
        
        return null;
    }
    
    /**
     * Find exact admin by email
     */
    public Admin findAdminByEmail(String email) {
        if (Admin.isEmpty(email)) {
            return null;
        }
        
        String emailLower = email.toLowerCase().trim();
        
        for (Admin admin : adminList) {
            if (admin.getEmail().toLowerCase().equals(emailLower)) {
                return admin;
            }
        }
        
        return null;
    }
    
    /**
     * Update admin information
     */
    public boolean updateAdmin(String adminID, String firstName, String lastName, String email, String phone) {
        Admin admin = findAdminByID(adminID);
        
        if (admin == null) {
            System.err.println("ERROR: Admin not found: " + adminID);
            return false;
        }
        
        // Check if new email conflicts with another admin
        if (!Admin.isEmpty(email) && !email.equals(admin.getEmail())) {
            if (isDuplicateEmail(email)) {
                System.err.println("ERROR: Email already in use: " + email);
                return false;
            }
        }
        
        // Update fields
        admin.updateProfile(firstName, lastName, email, phone);
        
        System.out.println("Admin updated: " + admin);
        return true;
    }
    
    /**
     * Remove admin by ID
     */
    public boolean removeAdmin(String adminID) {
        Admin admin = findAdminByID(adminID);
        
        if (admin == null) {
            System.err.println("ERROR: Admin not found: " + adminID);
            return false;
        }
        
        adminList.remove(admin);
        System.out.println("Admin removed: " + admin);
        return true;
    }
    
    /**
     * Remove admin object
     */
    public boolean removeAdmin(Admin admin) {
        if (admin == null || !adminList.contains(admin)) {
            return false;
        }
        
        adminList.remove(admin);
        System.out.println("Admin removed: " + admin);
        return true;
    }
    
    /**
     * Get all admins
     */
    public ArrayList<Admin> getAdminList() {
        return adminList;
    }
    
    /**
     * Get admin count
     */
    public int getAdminCount() {
        return adminList.size();
    }
    
    /**
     * Check if directory is empty
     */
    public boolean isEmpty() {
        return adminList.isEmpty();
    }
    
}
