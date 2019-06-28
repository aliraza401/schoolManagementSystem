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
public class Fees {
    private  int challan_no;
    private int amount;
    private Students s;

    public Fees(int challan_no, int amount, Students s) {
        this.challan_no = challan_no;
        this.amount = amount;
        this.s = s;
    }

    public int getChallan_no() {
        return challan_no;
    }

    public void setChallan_no(int challan_no) {
        this.challan_no = challan_no;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Students getS() {
        return s;
    }

    public void setS(Students s) {
        this.s = s;
    }
    
}
