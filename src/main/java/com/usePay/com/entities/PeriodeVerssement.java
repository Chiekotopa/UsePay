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
public class PeriodeVerssement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPeriode;
    private String periodeMax;

    public PeriodeVerssement() {
    }

    public Integer getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getPeriodeMax() {
        return periodeMax;
    }

    public void setPeriodeMax(String periodeMax) {
        this.periodeMax = periodeMax;
    }
    
    
    
}
