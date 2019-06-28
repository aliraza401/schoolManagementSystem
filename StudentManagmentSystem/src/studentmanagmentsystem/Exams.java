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
public class Exams {
    private int marks;
    private float percentage;
    private Students s;

    public Exams(int marks, float percentage, Students s) {
        this.marks = marks;
        this.percentage = percentage;
        this.s = s;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Students getS() {
        return s;
    }

    public void setS(Students s) {
        this.s = s;
    }
    
}
