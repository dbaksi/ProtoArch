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

@Named(value = "selectedBBean")
@SessionScoped

public class SelectedBBean implements Serializable {
    
private List<B> favoriteBs;
private B selectedB;
private HtmlDataTable datatableBs;
    
@ManagedProperty(value="#{bsManagedBean}")
private BsManagedBean bBean;

    public BsManagedBean getbBean() {
        return bBean;
    }

    public void setbBean(BsManagedBean bBean) {
        this.bBean = bBean;
    }


    public HtmlDataTable getDatatableBs() {
        return datatableBs;
    }

    public void setDatatableBs(HtmlDataTable datatableBs) {
        this.datatableBs = datatableBs;
    }

    public String deleteB()
    {
        selectedB = (B) datatableBs.getRowData();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        BsManagedBean neededBean = (BsManagedBean)facesContext.getApplication().createValueBinding("#{bsManagedBean}").getValue(facesContext);
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);

       // return "selectedB";
        mainBean.updateRemoveBList(selectedB);
        
        return neededBean.deleteAction(selectedB);
        
    }

    public String updateB()
    {
        // Get the selected row for update
        selectedB = (B) datatableBs.getRowData();
        // Get references to the associated managed beans for B and A respectively
        FacesContext facesContext = FacesContext.getCurrentInstance();
        BsManagedBean neededBean = (BsManagedBean)facesContext.getApplication().createValueBinding("#{bsManagedBean}").getValue(facesContext);
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);
        // Stick the data to be edited in the selected row to session ?
       //  FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);   
        session.setAttribute("oldB", selectedB);        
        // Make the default values ready for the update B page to be redirected to...
        neededBean.setB1(selectedB.getB1());
        neededBean.setB2(selectedB.getB2());
        neededBean.setB3(selectedB.getB3());
        neededBean.setB4(selectedB.getB4());
        neededBean.setB5(selectedB.getB5());
        //mainBean.updateRemoveBList(selectedB);
        
        return "editB?faces-redirect=true";      
    }    
    
    public List<B> getFavoriteBs() {
        return favoriteBs;
    }

    public void setFavoriteBs(List<B> favoriteBs) {
        this.favoriteBs = favoriteBs;
    }

    public B getSelectedB() {
        return selectedB;
    }

    public void setSelectedB(B selectedB) {
        this.selectedB = selectedB;
    }

}   
