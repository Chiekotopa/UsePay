/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class User implements Serializable{

    @Id
    private String username;
    private String password;
    @ManyToMany
    @JoinTable(name="USERS_ROLE")
    private Collection<Role>roles;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date DateNaiss;
    private String lieuNaiss;
    private String cni;
    private String nationalite;
    private String sexe;
    private String telephone;
    private String adresse;
    private String status;
    private Double solde;
    @Column(length = 255, unique = true)
    private Integer numeroCompte;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "idAgence", referencedColumnName = "idAgence")
    private Agence agence;
    private String TypeUser;
    private String userCreator;
    
    public User() {
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(Date DateNaiss) {
        this.DateNaiss = DateNaiss;
    }

    public String getLieuNaiss() {
        return lieuNaiss;
    }

    public void setLieuNaiss(String lieuNaiss) {
        this.lieuNaiss = lieuNaiss;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Integer getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Integer numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public String getUserName(){
        return username;
    }
    
    public void setUserName(String username){
        this.username=username;
    }
    
     public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
     public String getTypeUser(){
        return TypeUser;
    }
    
    public void setTypeUser(String typeUser){
        this.TypeUser=typeUser;
    }
    
     public String getUser(){
        return userCreator;
    }
    
    public void setUser(String user){
        this.userCreator=user;
    }
    
    public Collection<Role> getRoles(){
        return roles;
    }
    
    public void setRoles(Collection<Role>roles){
        this.roles=roles;
    }
   

}
