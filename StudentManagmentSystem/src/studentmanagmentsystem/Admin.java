/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagmentsystem;

/**
 *
 * @author hamza
 */
public class Admin {
    private  int admin_id;
    private String admin_Name;
    private String Password;

    public Admin(int admin_id, String admin_Name, String Password) {
        this.admin_id = admin_id;
        this.admin_Name = admin_Name;
        this.Password = Password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_Name() {
        return admin_Name;
    }

    public void setAdmin_Name(String admin_Name) {
        this.admin_Name = admin_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}

