/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Dao;

import com.usePay.com.entities.ClientStory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Chieko Topa
 */
public interface ClientStoryRepository extends JpaRepository<ClientStory, Integer> {
    
}
