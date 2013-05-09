/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rui
 */
@Entity
@Table(name = "a", catalog = "protopatternsimplest", schema = "")

@NamedQueries({
@NamedQuery(name="allAs", query="SELECT a FROM AEntity a WHERE a.a_id > 1"),
@NamedQuery(name="findAnA", query="SELECT a FROM AEntity a WHERE a.a1  = :first AND a.a2  = :second AND a.a3 = :third AND a.a4 = :fourth AND a.a5 =:fifth"),
@NamedQuery(name="findAllAsForQuery", query="SELECT a FROM AEntity a WHERE a.a1  = :first OR a.a2 = :second OR a.a3 = :third")
})

public class AEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "a_id")
    private Integer a_id;

    @Basic(optional = false)
    @Column(name = "a1")
    private String a1;

    @Basic(optional = false)
    @Column(name = "a2")
    private String a2;
    
    @Basic(optional = false)
    @Column(name = "a3")
    private String a3;
    
    @Basic(optional = false)
    @Column(name = "a4")
    private String a4;

    @Basic(optional = false)
    @Column(name = "a5")
    private String a5;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a")
    private Collection<BEntity> bCollection;

    public AEntity() {
    }

    public AEntity(Integer a_id) {
        this.a_id = a_id;
    }

     public AEntity(String a1, String a2, String a3, String a4, String a5) {
 
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;        
        this.a5 = a5;        
        
    }
    public AEntity(Integer a_id, String a1, String a2, String a3, String a4, String a5) {
        this.a_id = a_id;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;        
        this.a5 = a5;        
        
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_Id(Integer a_id) {
        this.a_id = a_id;
    }

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


    public Collection<BEntity> getBCollection() {
        return bCollection;
    }

    public void setBCollection(Collection<BEntity> bCollection) {
        this.bCollection = bCollection;
    }

}
