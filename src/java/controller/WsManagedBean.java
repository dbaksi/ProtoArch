/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.Dependent;
import org.me.calculator.CalculatorWSService;
import org.me.calculator.CalculatorWS;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;


/**
 *
 * @author Dibyendu
 */
@Named(value = "wsManagedBean")
@SessionScoped
public class WsManagedBean implements Serializable {

    /**
     * Creates a new instance of WsManagedBean
     */
    public WsManagedBean() {
    }
    public WsManagedBean(int i, int j) {
        this.first = i;
        this.second = j;
    }
    private int first;
    private int second;
    private int result;
    
    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
        public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
        
    public String compute() {
        	CalculatorWSService calService = new CalculatorWSService();
	CalculatorWS cal = calService.getCalculatorWSPort();
                     System.out.println("Value of first is : from JSF ");
                     System.out.print(getFirst());
                     System.out.println("Value of second is : from JSF ");
                     System.out.print(getSecond());
                     //int res = cal.add(getFirst(), getSecond());
                     //setResult(res);
                     setResult(cal.add(getFirst(), getSecond()));
	System.out.println("Value of result is :");
                     System.out.print(getResult());
                     return ("computeRes");
    }
            
}
