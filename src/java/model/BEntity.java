/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rui
 */
@Entity
@Table(name = "b", catalog = "protopatternsimplest", schema = "")

@NamedQueries({
@NamedQuery(name="allBs", query="SELECT b FROM BEntity b WHERE b.b_id > 1"),
@NamedQuery(name="findB", query="SELECT b FROM BEntity b WHERE b.b1  = :first AND b.b2  = :second AND b.b3 = :third AND b.b4 = :fourth AND b.b5 =:fifth"),
@NamedQuery(name="findAllBsForAA", query="SELECT b FROM BEntity b WHERE b.a.a_id = :id")
})

public class BEntity implements Serializable {
   
    @Id
    @GeneratedValue
    @Column(name = "b_id")
    private Integer b_id;

    @Basic(optional = false)
    @Column(name = "b1")
    private String b1;

    @Basic(optional = false)
    @Column(name = "b2")
    private String b2;
    
    @Basic(optional = false)
    @Column(name = "b3")
    private String b3;
    
    @Basic(optional = false)
    @Column(name = "b4")
    private String b4;
    
    @Basic(optional = false)
    @Column(name = "b5")
    private String b5;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "A_a_id", referencedColumnName = "a_id", insertable = true)
    private AEntity a;

    public BEntity() {
    }

    public BEntity(Integer b_id) {
        this.b_id = b_id;
    }

    
    public BEntity (String b1, String b2, String b3, String b4, String b5, AEntity a) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.a = a;
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
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


    public AEntity getAEntity() {
        return a;
    }

    public void setAEntity(AEntity a) {
        this.a = a;
    }
    
}
