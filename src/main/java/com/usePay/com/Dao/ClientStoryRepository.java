/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Dao;

import com.usePay.com.entities.ClientStory;
import com.usePay.com.entities.CommercialStory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Chieko Topa
 */
public interface ClientStoryRepository extends JpaRepository<ClientStory, Integer> {
    
    @Query(value ="SELECT cs FROM ClientStory cs WHERE cs.user.username=:username")
    public List<ClientStory>findStoryByIduser(@Param(value = "username")String username);
}
