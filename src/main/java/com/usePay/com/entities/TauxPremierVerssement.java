/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chieko Topa
 */
@Table
@Entity
public class TauxPremierVerssement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTaux;
    private Double taux;
    

    public TauxPremierVerssement() {
    }

    public Integer getIdTaux() {
        return idTaux;
    }

    public void setIdTaux(Integer idTaux) {
        this.idTaux = idTaux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
    
    

}
