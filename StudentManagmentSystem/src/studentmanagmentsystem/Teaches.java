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
public class Teaches {
    protected Teacher t;
    protected Courses c;

    public Teaches(Teacher t, Courses c){ 
        this.t = t;
        this.c = c;
    }

   

    public Teacher getT() {
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }

    public Courses getC() {
        return c;
    }

    public void setC(Courses c) {
        this.c = c;
    }
    
}
