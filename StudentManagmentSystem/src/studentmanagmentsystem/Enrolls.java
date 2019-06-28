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
public class Enrolls {
        private Department d;
    private Students s;

    public Enrolls(Department d, Students s) {
        this.d = d;
        this.s = s;
    }

    public Department getD() {
        return d;
    }

    public void setD(Department d) {
        this.d = d;
    }

    public Students getS() {
        return s;
    }

    public void setS(Students s) {
        this.s = s;
    }


 
}
