/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import com.usePay.com.Entities.Produits;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author chiek
 */
@Entity
@Table
public class Souscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSouscription;
    private LocalDateTime dateSouscription;
    private LocalDate dateDebut;
    private LocalDate duree;
    private double montantJour;
    private double tauxPenalite;
    private double montantDet;
    private double versement;
    private double versementJour;
    @ManyToOne
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit")
    private Produits produits;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "iduser")
    private Users user;

    public Souscription() {
    }

    public double getMontantDet() {
        return montantDet;
    }

    public void setMontantDet(double montantDet) {
        this.montantDet = montantDet;
    }

    public double getVersement() {
        return versement;
    }

    public void setVersement(double versement) {
        this.versement = versement;
    }

    public Integer getIdSouscription() {
        return idSouscription;
    }

    public void setIdSouscription(Integer idSouscription) {
        this.idSouscription = idSouscription;
    }

  

    public LocalDateTime getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(LocalDateTime dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDuree() {
        return duree;
    }

    public void setDuree(LocalDate duree) {
        this.duree = duree;
    }

    public double getMontantJour() {
        return montantJour;
    }

    public void setMontantJour(double montantJour) {
        this.montantJour = montantJour;
    }

    public double getTauxPenalite() {
        return tauxPenalite;
    }

    public void setTauxPenalite(double tauxPenalite) {
        this.tauxPenalite = tauxPenalite;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public double getVersementJour() {
        return versementJour;
    }

    public void setVersementJour(double versementJour) {
        this.versementJour = versementJour;
    }
    
    

}
