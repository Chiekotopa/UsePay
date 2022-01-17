/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.dao;

import com.usePay.com.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chiek
 */
public interface AgenceRepository extends JpaRepository<Agence, Integer> {
    
}
