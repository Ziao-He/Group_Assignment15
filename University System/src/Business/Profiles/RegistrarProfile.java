/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
 * @author 心火牧神塞勒斯
 */
public class RegistrarProfile extends Profile {
    
    private String registrarId;
    private String email;
    private String phone;
    private String officeHours;
    private String officeLocation;

    public RegistrarProfile(Person p) {
        super(p);
    }

    // 完整的构造函数
    public RegistrarProfile(Person p, String registrarId, String email, String phone, String officeHours, String officeLocation) {
        super(p);
        this.registrarId = registrarId;
        this.email = email;
        this.phone = phone;
        this.officeHours = officeHours;
        this.officeLocation = officeLocation;
    }

    // Getter 和 Setter 方法
    public String getRegistrarId() {
        return registrarId;
    }

    public void setRegistrarId(String registrarId) {
        this.registrarId = registrarId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    @Override
    public String getRole() {
        return "Registrar";
    }

    @Override
    public String toString() {
        return "Registrar{" +
                "id='" + registrarId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
