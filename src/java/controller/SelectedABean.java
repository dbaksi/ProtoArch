/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.html.HtmlDataTable;
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

@Named(value = "selectedABean")
@SessionScoped

public class SelectedABean implements Serializable {
    
private List<A> favoriteAs;
private A selectedA;
private HtmlDataTable datatableAs;
    
@ManagedProperty(value="#{asManagedBean}")
private AsManagedBean aBean;

    public AsManagedBean getaBean() {
        return aBean;
    }

    public void setaBean(AsManagedBean aBean) {
        this.aBean = aBean;
    }


    public HtmlDataTable getDatatableAs() {
        return datatableAs;
    }

    public void setDatatableAs(HtmlDataTable datatableAs) {
        this.datatableAs = datatableAs;
    }

    public String viewA()
    {
        System.out.println("Inside SelectedABean.viewA()");
        // Get the selected row for update
        selectedA = (A) datatableAs.getRowData();
        // Get references to the associated managed beans for B and A respectively
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);
        
        EntityManager em = (EntityManager) Persistence.createEntityManagerFactory("MyPU").createEntityManager();     
        //System.out.println("Inside viewAction(A a)");
        
        Query query=em.createNamedQuery("findAnA");
        query.setParameter("first", selectedA.getA1());
        query.setParameter("second", selectedA.getA2());
        query.setParameter("third", selectedA.getA3());
        query.setParameter("fourth", selectedA.getA4());        
        query.setParameter("fifth", selectedA.getA5());        

        AEntity anEnA = (AEntity) query.getSingleResult();  
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);     
        session.setAttribute("refId", anEnA);  
        Integer pk =  anEnA.getA_id();
        System.out.println("Retrieved primary key of A is  :");
        System.out.println(pk);
        List<B> relatedBs = mainBean.getBList(pk);
        mainBean.setBList(relatedBs);
               
       return "viewAbs?faces-redirect=true";      
    }  
    
    public String updateA()
    {
        // Get the selected row for update
        selectedA = (A) datatableAs.getRowData();
        // Get references to the associated managed beans for B and A respectively
        FacesContext facesContext = FacesContext.getCurrentInstance();
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);
        // Stick the data to be edited in the selected row to session ?
       //  FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);   
        session.setAttribute("oldA", selectedA);        
        // Make the default values ready for the update B page to be redirected to...
            
        return "editA?faces-redirect=true";      
    }  
    
    public A getSelectedA() {
        return selectedA;
    }

    public void setSelectedA(A selectedA) {
        this.selectedA = selectedA;
    }

}   

