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
public class UsersStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserStory;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    private String transactionType;
    private double transactionBalance;
    private double oldBalance;
    private double newBalance;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "username")
    private User user;

    public UsersStory() {
    }

    public Integer getIdclientStory() {
        return idUserStory;
    }

    public void setIdclientStory(Integer idUserStory) {
        this.idUserStory = idUserStory;
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

    public double getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(double transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public double getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(double oldBalance) {
        this.oldBalance = oldBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    
    public User getClient() {
        return user;
    }

    public void setClient(User user) {
        this.user = user;
    }
    
    
    
    
}
