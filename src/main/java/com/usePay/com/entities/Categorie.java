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
@Table(name = "categorie")
public class Categorie implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "designation")
    private String designation;

    public Categorie() {
    }

    public Categorie(String designation) {
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
