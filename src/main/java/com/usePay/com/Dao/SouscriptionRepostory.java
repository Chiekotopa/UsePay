/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.dao;

import com.usePay.com.entities.Souscription;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author chiek
 */
public interface SouscriptionRepostory extends JpaRepository<Souscription, Integer> {
    
    @Query(value ="SELECT s FROM Souscription s WHERE s.user.username=:username")
    public List<Souscription>findSouscriptionByIduser(@Param(value = "username")String username);
}
