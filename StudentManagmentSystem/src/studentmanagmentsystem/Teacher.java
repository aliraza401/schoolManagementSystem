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
public class Teacher {
    private int  teacher_id;
    private String teacher_Name;
    private String designation;
    private int salary;
    private String Gender;
        private  int  Cnic;

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_Name() {
        return teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        this.teacher_Name = teacher_Name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getCnic() {
        return Cnic;
    }

    public void setCnic(int Cnic) {
        this.Cnic = Cnic;
    }

    public Teacher(int teacher_id, String teacher_Name, String designation, int salary, String Gender, int Cnic) {
        this.teacher_id = teacher_id;
        this.teacher_Name = teacher_Name;
        this.designation = designation;
        this.salary = salary;
        this.Gender = Gender;
        this.Cnic = Cnic;
    }

    public Teacher(int teacher_id) {
        this.teacher_id = teacher_id;
    }

}