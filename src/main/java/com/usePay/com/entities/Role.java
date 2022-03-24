/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author chiek
 */
@Entity
@Table
public class Role implements Serializable {
    @Id
    private String role;
    
    @Column
    private String description;

    public Role() {
    }

    public String getRoles() {
        return role;
    }

    public void setRole(String roles) {
        this.role = roles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
