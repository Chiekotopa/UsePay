/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.dao;

import com.usePay.com.entities.ClientStory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author chiek
 */
public interface ClientStoryRepository extends JpaRepository<ClientStory, Integer> {

    @Query(value ="SELECT cs FROM ClientStory cs WHERE cs.client.idClient=:idclient")
    public List<ClientStory>findStoryByIdClient(@Param(value = "idclient")int idclient);

    

}
