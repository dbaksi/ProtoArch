/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Dibyendu
 */
public class B {

    public B(int b_id, String b1, String b2, String b3, int a_id_ref) {
        this.b_id = b_id;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.a_id_ref = a_id_ref;
    }

        public B(int b_id, String b1, String b2, String b3, String b4, String b5) {
        this.b_id = b_id;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
 
    }
        
        public B(String b1, String b2, String b3, String b4, String b5) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
 
    }        
        
    public B() {
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

        public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    
    public int getA_id_ref() {
        return a_id_ref;
    }

    public void setA_id_ref(int a_id_ref) {
        this.a_id_ref = a_id_ref;
    }
    int b_id;
    String b1;
    String b2;
    String b3;
    String b4;
    String b5;
    
    int a_id_ref;
    
}
