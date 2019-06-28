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
public class Registered {
    private Students s;
    private Courses c;

    public Registered(Students s, Courses c) {
        this.s = s;
        this.c = c;
    }

    public Students getS() {
        return s;
    }

    public void setS(Students s) {
        this.s = s;
    }

    public Courses getC() {
        return c;
    }

    public void setC(Courses c) {
        this.c = c;
    }
    
    
    
}
