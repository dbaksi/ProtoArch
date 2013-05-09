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
import javax.faces.bean.ManagedBean;
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
@Named(value = "asManagedBean")
@SessionScoped
public class AsManagedBean implements Serializable {

    private static EntityManager em = null;
    private AEntity myEntity;
    /**
     * Creates a new instance of AsManagedBean
     */
    public AsManagedBean() {
    }
   
        private String a1;
        private String a2;
        private String a3;
        private String a4;
        private String a5;
        
        private List<B> bList = new ArrayList<B>();        
      
/*
        private Integer a_id;
        
        

        
  public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }
 */
        
    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }
    
    
    public void setMyEntity(AEntity a) {
        this.myEntity = a;
    }
    
    public AEntity getMyEntity() {
        return myEntity;
    }
   
    private static EntityManager getEntityManager() {
        em = (EntityManager) Persistence.createEntityManagerFactory("MyPU").createEntityManager(); 
        return em;
    }

    public String createAnA() {

        AEntity anEnA = new AEntity(this.getA1(), this.getA2(), this.getA3(), this.getA4(), this.getA5());
        
        em = getEntityManager();
        em.getTransaction().begin();
        System.out.println("Inside createAnA");
      

        /*
        //anEnA.setA_Id((Integer) 3);
        anEnA.setA1(this.getA1());
        anEnA.setA2(this.getA2());
        anEnA.setA3(this.getA3());
        anEnA.setA4(this.getA4());
        anEnA.setA5(this.getA5());        
        */
//        A anA =new A();
        /*
        anA.setA1(this.getA1());
        anA.setA2(this.getA2());
        anA.setA3(this.getA3());
        anA.setA4(this.getA4());
        anA.setA5(this.getA5());  
        */
        /*
        anA.setA1(a1);
        anA.setA2(a2);
        anA.setA3(a3);
        anA.setA4(a4);
        anA.setA5(a5);    
        */
      /*
        System.out.print(" First col  to be created A : " + anEnA.getA1());
        System.out.print(" Second col to be created A : " + anEnA.getA2());
        System.out.print(" Third col of to be created A : " + anEnA.getA3());
        System.out.print(" Fourth col of to be created A : " + anEnA.getA4());
        System.out.print(" Fifth col of to be created A : " + anEnA.getA5());    
      */
/*
        anEnA.setA1("a51");
        anEnA.setA2("a52");
        anEnA.setA3("a53");
        anEnA.setA4("a54");
        anEnA.setA5("a55");
*/
        
//        System.out.print(" First col of to be created A : " + anEnA.getA1());
//        System.out.print(" Second col of to be created A : " + anEnA.getA2());
        
        em.persist(anEnA);
        //em.flush();
        em.getTransaction().commit();
        setMyEntity(anEnA);
        
     
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
      
        session.setAttribute("refId", anEnA);
        return ("showA");
 
    }
   
    
    List<A> aList = new ArrayList<A>();
   
    public String processSearchA() {
        getAList();
        return "listA";
    }
    
    public String viewAbs() {
        return "viewAbs";
    }
    
    public List<A> getAList() {

        em = getEntityManager();     
        System.out.println("Inside list of A Query");
       
        Query query=em.createNamedQuery("findAllAsForQuery");
        query.setParameter("first", a1);
        query.setParameter("second", a2);
        query.setParameter("third", a3);

        List<AEntity> aEList = query.getResultList();
        Iterator iter = aEList.iterator();
        aList.clear();
        while (iter.hasNext()) {
           
        AEntity aA = (AEntity) iter.next();
        A someA = new A();
                    
        someA.setA1((String) aA.getA1());
        someA.setA2((String) aA.getA2());
        someA.setA3((String) aA.getA3());        
        someA.setA4((String) aA.getA4());        
        someA.setA5((String) aA.getA5());        
        
        System.out.print(" First col of an A : " + someA.getA1());
        System.out.print(" Second col of an A : " + someA.getA2());
        System.out.print(" First col of an A : " + someA.getA3());
        System.out.print(" Second col of an A : " + someA.getA4());
        System.out.print(" Second col of an A : " + someA.getA5());
        aList.add(someA);
        }
        
        return aList;
        
    }
    
    public A getAnA() {
        
        em = getEntityManager();
        A anA = new A();
//         System.out.println("Inside testQuery");
       
        //em.getTransaction().begin();        //first query
        Query query=em.createNamedQuery("findAnA");
        //query.setParameter(1, 100);
    
        List<AEntity> lstA= query.getResultList();
        Iterator iter = lstA.iterator();      
        
        while (iter.hasNext()) {
            //AEntity empl = (AEntity) iter.next();
            AEntity someA = (AEntity) iter.next();
        //  System.out.print(" First col of an A : " + someA.getA1());
        //  System.out.print(" Second col of an A : " + someA.getA2());
   
            
            anA.setA1((String) someA.getA1());
            anA.setA2((String) someA.getA2());
            anA.setA3((String) someA.getA3());
            anA.setA4((String) someA.getA4());
            anA.setA5((String) someA.getA5());          
           
        }
        
        return anA;
    }
     
    public List<B> getAssocBs() {
        return bList;
    }
    
    public List<B> getBList(Integer aid) {

        em = getEntityManager();     
        System.out.println("Inside testQuery");
        
        SelectedBBean selB = new SelectedBBean();
       
        Query query=em.createNamedQuery("findAllBsForAA");
        query.setParameter("id", aid);

        List<BEntity> bElist = query.getResultList();
        Iterator iter = bElist.iterator();
        bList.clear();
        while (iter.hasNext()) {
           
        BEntity aB = (BEntity) iter.next();
        B someB = new B();
        
        //  System.out.print(" First col of an A : " + someA.getA1());
        //  System.out.print(" Second col of an A : " + someA.getA2());
            
        someB.setB1((String) aB.getB1());
        someB.setB2((String) aB.getB2());
        someB.setB3((String) aB.getB3());        
        someB.setB4((String) aB.getB4());        
        someB.setB5((String) aB.getB5());        
        
        
        bList.add(someB);
        }
        selB.setFavoriteBs(bList);
        return bList;
    }

    public void setBList(List<B> bList) {
       this.bList = bList;
    }       
    
    public String deleteAction(A a) { 
        em = getEntityManager();     
        System.out.println("Inside delete of A Query");
        em.getTransaction().begin();
        
        Query query=em.createNamedQuery("findAnA");
        query.setParameter("first", a1);
        query.setParameter("second", a2);
        query.setParameter("third", a3);
        query.setParameter("fourth", a4);        
        query.setParameter("fifth", a5);        

        AEntity anA = (AEntity) query.getSingleResult();
        
        em.remove(anA);
        em.getTransaction().commit();
        return "listA?faces-redirect=true";
    }

    public String createAction(A a) { 
        return "createA";
    }
    
    public String editAction(A a) { 
        em = getEntityManager();     
        System.out.println("Inside update of A");
        AEntity newEnA = new AEntity(this.getA1(), this.getA2(), this.getA3(), this.getA4(), this.getA5());
        em.getTransaction().begin();
               
        em.merge(newEnA);
        em.getTransaction().commit();
        return "listA?faces-redirect=true";
    }

    public String viewAction(A a) { 
        
        em = getEntityManager();     
        System.out.println("Inside view of A Query");
        
        Query query=em.createNamedQuery("findAnA");
        query.setParameter("first", a1);
        query.setParameter("second", a2);
        query.setParameter("third", a3);
        query.setParameter("fourth", a4);        
        query.setParameter("fifth", a5);        

        AEntity anEnA = (AEntity) query.getSingleResult();
        setA1((String) anEnA.getA1());
        setA2((String) anEnA.getA2());
        setA3((String) anEnA.getA3());
        setA4((String) anEnA.getA4());
        setA5((String) anEnA.getA5());     
        
        setBList(getBList(anEnA.getA_id()));
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);     
        session.setAttribute("refId", anEnA);        
        
        return "viewAbs?faces-redirect=true";
    }
      
}
    
