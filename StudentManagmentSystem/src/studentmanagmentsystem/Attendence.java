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
public class Attendence  {
    private int attendence_id;
    private int attend_lecture;
    private float percentage;
private Teacher t1;
private Students s1;

    public Attendence(int attendence_id, int attend_lecture, float percentage, Teacher t1, Students s1) {
        this.attendence_id = attendence_id;
        this.attend_lecture = attend_lecture;
        this.percentage = percentage;
        this.t1 = t1;
        this.s1 = s1;
    }

    public int getAttendence_id() {
        return attendence_id;
    }

    public void setAttendence_id(int attendence_id) {
        this.attendence_id = attendence_id;
    }

    public int getAttend_lecture() {
        return attend_lecture;
    }

    public void setAttend_lecture(int attend_lecture) {
        this.attend_lecture = attend_lecture;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Teacher getT1() {
        return t1;
    }

    public void setT1(Teacher t1) {
        this.t1 = t1;
    }

    public Students getS1() {
        return s1;
    }

    public void setS1(Students s1) {
        this.s1 = s1;
    }
 
    
}
