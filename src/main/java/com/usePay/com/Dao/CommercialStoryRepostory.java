/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.dao;

import com.usePay.com.entities.CommercialStory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author chiek
 */
public interface CommercialStoryRepostory extends JpaRepository<CommercialStory, Integer> {

    @Query(value ="SELECT us FROM UsersStory us WHERE us.user.username=:username")
    public List<CommercialStory>findStoryByIduser(@Param(value = "username")String username);

    

}
