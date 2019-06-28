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
public class Courses {
    private int course_id;
    private String Course_Name;
    private int course_code;
    private int credits_hour;

    public Courses(int course_id, String Course_Name, int course_code, int credits_hour) {
        this.course_id = course_id;
        this.Course_Name = Course_Name;
        this.course_code = course_code;
        this.credits_hour = credits_hour;
    }

    public Courses(int course_id) {
        this.course_id = course_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String Course_Name) {
        this.Course_Name = Course_Name;
    }

    public int getCourse_code() {
        return course_code;
    }

    public void setCourse_code(int course_code) {
        this.course_code = course_code;
    }

    public int getCredits_hour() {
        return credits_hour;
    }

    public void setCredits_hour(int credits_hour) {
        this.credits_hour = credits_hour;
    }
    
}
