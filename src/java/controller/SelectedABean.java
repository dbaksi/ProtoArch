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
        // Get the selected row for update
        selectedA = (A) datatableAs.getRowData();
        // Get references to the associated managed beans for B and A respectively
        FacesContext facesContext = FacesContext.getCurrentInstance();
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);
        mainBean.setA1(selectedA.getA1());
        mainBean.setA2(selectedA.getA2());
        mainBean.setA3(selectedA.getA3());
        mainBean.setA4(selectedA.getA4());
        mainBean.setA5(selectedA.getA5());
        // Stick the data to be edited in the selected row to session ?
       //  FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);   
        session.setAttribute("oldA", selectedA);        
        // Make the default values ready for the update B page to be redirected to...
        /*
        neededBean.setB1(selectedB.getB1());
        neededBean.setB2(selectedB.getB2());
        neededBean.setB3(selectedB.getB3());
        neededBean.setB4(selectedB.getB4());
        neededBean.setB5(selectedB.getB5());
        */
        //mainBean.updateRemoveBList(selectedB);
        
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
        /*
        neededBean.setB1(selectedB.getB1());
        neededBean.setB2(selectedB.getB2());
        neededBean.setB3(selectedB.getB3());
        neededBean.setB4(selectedB.getB4());
        neededBean.setB5(selectedB.getB5());
        */
        //mainBean.updateRemoveBList(selectedB);
        
        return "editA?faces-redirect=true";      
    }  
    
    public A getSelectedA() {
        return selectedA;
    }

    public void setSelectedA(A selectedA) {
        this.selectedA = selectedA;
    }

}   

