/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Dao;

import com.usePay.com.entities.Galery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chiek
 */
public interface GaleryRepository extends JpaRepository<Galery, Integer> {
    
}
