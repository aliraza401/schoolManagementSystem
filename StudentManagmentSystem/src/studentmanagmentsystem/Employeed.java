
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
public class Employeed {
    private Teacher t;
    private Department d;

    public Employeed(Teacher t, Department d) {
        this.t = t;
        this.d = d;
    }

    public Teacher getT() {
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }

    public Department getD() {
        return d;
    }

    public void setD(Department d) {
        this.d = d;
    }
    
    
    
}
