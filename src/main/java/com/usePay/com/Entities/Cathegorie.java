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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cathegorie.findAll", query = "SELECT c FROM Cathegorie c"),
    @NamedQuery(name = "Cathegorie.findBycodeProduits", query = "SELECT c FROM Cathegorie c WHERE c.designation = :designation")})
public class Cathegorie implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "designation")
    private String designation;
    
  public Cathegorie() {
    }

    public Cathegorie(String designation) {
        this.designation = designation;
    }

    public String getCodeProduits() {
        return designation;
    }

    public void setCodeProduits(String designation) {
        this.designation = designation;
    }
    @Override
    public String toString() {
        return "com.example.App.Entities.Anneeacad[ designation=" + designation + " ]";
    }
}    

