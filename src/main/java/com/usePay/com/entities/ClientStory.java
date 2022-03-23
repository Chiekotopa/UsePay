/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import java.io.Serializable;
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
 * @author Chieko Topa
 */
@Entity
@Table
public class ClientStory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClientStory;

    private LocalDateTime transactionDate;
    private String transactionType;
    private double versement;
    private double oldDette;
    private double newDette;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "iduser")
    private Users user;

    public ClientStory() {
    }

    public Integer getIdClientStory() {
        return idClientStory;
    }

    public void setIdClientStory(Integer idClientStory) {
        this.idClientStory = idClientStory;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getVersement() {
        return versement;
    }

    public void setVersement(Double versement) {
        this.versement = versement;
    }

    public Double getOldDette() {
        return oldDette;
    }

    public void setOldDette(Double oldDette) {
        this.oldDette = oldDette;
    }

    public double getNewDette() {
        return newDette;
    }

    public void setNewDette(double newDette) {
        this.newDette = newDette;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    
}
