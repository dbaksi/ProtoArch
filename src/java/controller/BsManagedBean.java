/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import model.*;

/**
 *
 * @author Dibyendu
 */
@Named(value = "bsManagedBean")
@SessionScoped
public class BsManagedBean implements Serializable {
    
    private static EntityManager em = null;
   
    /**
     * Creates a new instance of BsManagedBean
     */
 
    public BsManagedBean() {
      
    }
   
        private String b1;
        private String b2;
        private String b3;
        private String b4;
        private String b5;
       
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
              
   
    private static EntityManager getEntityManager() {
        em = (EntityManager) Persistence.createEntityManagerFactory("MyPU").createEntityManager(); 
        return em;
    }


    public String createB() {

        em = getEntityManager();
        
        em.getTransaction().begin();
        System.out.println("Inside createB");
        
         FacesContext facesContext = FacesContext.getCurrentInstance();
         HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
         AEntity myA = (AEntity) session.getAttribute("refId");
         
         System.out.println("The inserted A's Pk is  : ");
         System.out.println(myA.getA_id());
        
        BEntity anEnB = new BEntity(this.getB1(), this.getB2(), this.getB3(), this.getB4(), this.getB5(), myA);
        B newB = new B(this.getB1(), this.getB2(), this.getB3(), this.getB4(), this.getB5());   
        em.persist(anEnB);
        
 //       em.flush();
       
        em.getTransaction().commit();
        em.refresh(anEnB);
        
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);
        mainBean.updateAddBList(newB);        
        return ("viewAbs?faces-redirect=true");
 
    }
   
    
    public String deleteAction(B b) { 
        em = getEntityManager();     
        System.out.println("Inside delete of A Query");

        em.getTransaction().begin();
        
        Query query=em.createNamedQuery("findB");
        query.setParameter("first", b.b1);
        query.setParameter("second", b.b2);
        query.setParameter("third", b.b3);
        query.setParameter("fourth", b.b4);        
        query.setParameter("fifth", b.b5);        

        BEntity aB = (BEntity) query.getSingleResult();
       
        em.remove(aB);
        em.getTransaction().commit();
        /*
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        AEntity myA = (AEntity) session.getAttribute("refId");  
       */

       return "viewAbs?faces-redirect=true";

    }
    
    public String createAction(B b) { 
        return "createB?faces-redirect=true";
    }
}
