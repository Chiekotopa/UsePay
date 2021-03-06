/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Entities;

import com.usePay.com.entities.Galery;
import com.usePay.com.entities.TauxPremierVerssement;
import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "produits")
public class Produits implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduit")
    private Integer idProduit;
    
    @Column(name = "nom",unique = true)
    private String nom;
      
    @Column(name = "description")
    private String description;
    
    @Column(name = "prix")
    private Double prix;
    
    @JoinColumn(name = "categorie", referencedColumnName = "idcategorie")
    @ManyToOne(optional = false)
    private Categorie categorie;
    
    @JoinColumn(name = "idTauxVersement", referencedColumnName = "idTaux")
    @ManyToOne(optional = false)
    private TauxPremierVerssement tauxPremierVerssement;
    
    
    
    public Produits(){
        
    }

    public TauxPremierVerssement getTauxPremierVerssement() {
        return tauxPremierVerssement;
    }

    public void setTauxPremierVerssement(TauxPremierVerssement tauxPremierVerssement) {
        this.tauxPremierVerssement = tauxPremierVerssement;
    }

    
    public Produits(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    

    
    
    
    
}
