/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.dao;

import com.usePay.com.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chiek
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value ="SELECT u FROM User u WHERE u.TypeUser='Client'")
    public List<User>findListClients();
    
     @Query(value ="SELECT u FROM User u WHERE u.TypeUser='Commercial'")
    public List<User>findListCommercial();
}
