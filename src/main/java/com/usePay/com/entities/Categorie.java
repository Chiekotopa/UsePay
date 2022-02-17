/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Entities;

import com.usePay.com.entities.PeriodeVerssement;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorie")
    private Integer idcategorie;
   
    private String designation;
    
    @JoinColumn(name = "periode", referencedColumnName = "idPeriode")
    @ManyToOne(optional = false)
    private PeriodeVerssement periodeVerssement;
    
    public Categorie() {
    }


    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public PeriodeVerssement getPeriodeVerssement() {
        return periodeVerssement;
    }

    public void setPeriodeVerssement(PeriodeVerssement periodeVerssement) {
        this.periodeVerssement = periodeVerssement;
    }

    public String getDesignation() {
        return designation;
    }

    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    
}
