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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "produits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p"),
    @NamedQuery(name = "Produits.findById", query = "SELECT p FROM Produits p WHERE p.idProduit = :idProduit")})
public class Produits implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduit")
    private Integer idProduit;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "prix")
    private String prix;
    
    @JoinColumn(name = "categorie_designation", referencedColumnName = "designation")
    @ManyToOne(optional = false)
        private Categorie categoriedesignation;
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

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategoriedesignation() {
        return categoriedesignation;
    }

    public void setCategoriedesignation(Categorie categoriedesignation) {
        this.categoriedesignation = categoriedesignation;
    }

    
    
    
}
