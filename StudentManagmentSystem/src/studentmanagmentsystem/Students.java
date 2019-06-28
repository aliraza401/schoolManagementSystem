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
public class Students {
  private int student_id;
    private String student_name;
    private int Cnic;
    private String Gender;

    public Students(int student_id) {
        this.student_id = student_id;
    }
    public Students(int student_id, String student_name, int Cnic, String Gender) {
      
        this.student_id = student_id;
        this.student_name = student_name;
        this.Cnic = Cnic;
        this.Gender = Gender;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getCnic() {
        return Cnic;
    }

    public void setCnic(int Cnic) {
        this.Cnic = Cnic;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
  
    
    
}
