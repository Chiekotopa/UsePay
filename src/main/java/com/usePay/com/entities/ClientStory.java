/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import java.io.Serializable;
import java.util.Date;
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
public class ClientStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclientStory;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    private String transactionType;
    private double transactionSolde;
    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

    public ClientStory() {
    }

    public Integer getIdclientStory() {
        return idclientStory;
    }

    public void setIdclientStory(Integer idclientStory) {
        this.idclientStory = idclientStory;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionSolde() {
        return transactionSolde;
    }

    public void setTransactionSolde(double transactionSolde) {
        this.transactionSolde = transactionSolde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
    
}
