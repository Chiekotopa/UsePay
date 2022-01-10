/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "produits")
public class Produits implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "designation")
    private String designation;
    
    @Column(name = "nom")
    private String nom;
  
    @Column(name = "prix")
    private String prix;
    
    public Produits(){
        
    }
    public Produits(String designation) {
        this.designation = designation;
    }
    
    public Produits(String designation, String nom, String prix) {
        this.designation = designation;
        this.nom = nom;
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    
    
}
