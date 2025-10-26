/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author 心火牧神塞勒斯
 */
public class RegistrarDirectory {
    private ArrayList<RegistrarProfile> registrarList;

    public RegistrarDirectory() {
        registrarList = new ArrayList<>();
    }

    public RegistrarProfile newRegistrarProfile(Person p) {
        RegistrarProfile rp = new RegistrarProfile(p);
        registrarList.add(rp);
        return rp;
    }

    // 重载方法，支持完整信息创建
    public RegistrarProfile newRegistrarProfile(Person p, String registrarId, String email, String phone, String officeHours, String officeLocation) {
        RegistrarProfile rp = new RegistrarProfile(p, registrarId, email, phone, officeHours, officeLocation);
        registrarList.add(rp);
        return rp;
    }

    public RegistrarProfile findRegistrar(String id) {
        for (RegistrarProfile rp : registrarList) {
            if (rp.isMatch(id)) {
                return rp;
            }
        }
        return null;
    }

    public ArrayList<RegistrarProfile> getRegistrarList() {
        return registrarList;
    }
}
