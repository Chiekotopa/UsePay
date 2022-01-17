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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "prix")
    private String prix;
    
    @JoinColumn(name = "categorie_designation", referencedColumnName = "designation")
    @ManyToOne(optional = false)
    private Cathegorie categoriedesignation;
    public Produits(){
        
    }
    
    public Produits(String nom, String prix) {
        this.nom = nom;
        this.prix = prix;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cathegorie getCategoriedesignation() {
        return categoriedesignation;
    }

    public void setCategoriedesignation(Cathegorie categoriedesignation) {
        this.categoriedesignation = categoriedesignation;
    }

    
    
    
}
