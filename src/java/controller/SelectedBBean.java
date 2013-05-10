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

    public String addB()
    {
        selectedB = (B) datatableBs.getRowData();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        BsManagedBean neededBean = (BsManagedBean)facesContext.getApplication().createValueBinding("#{bsManagedBean}").getValue(facesContext);
        AsManagedBean mainBean = (AsManagedBean)facesContext.getApplication().createValueBinding("#{asManagedBean}").getValue(facesContext);

       // return "selectedB";
        mainBean.updateRemoveBList(selectedB);
        
        return neededBean.deleteAction(selectedB);
        
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
