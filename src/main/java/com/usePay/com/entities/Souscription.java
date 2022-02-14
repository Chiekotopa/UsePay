/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import com.usePay.com.Entities.Produits;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author chiek
 */
@Entity
@Table
public class Souscription implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSouscription;
    @Column(length = 155,unique = true)
    private int numero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSouscription;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date duree;
    private double montantJour;
    private double tauxPenalite;
    private double montantDet;
    private double versement;
    @ManyToOne
    @JoinColumn(name = "idProduit",referencedColumnName = "idProduit")
    private Produits produits;
    @ManyToOne
    @JoinColumn(name = "user",referencedColumnName = "username")
    private User user;
    

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(Date dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    

}
