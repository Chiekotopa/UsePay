/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Dao;

import com.usePay.com.Entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author MIKE
 */
public interface ProduitsRepository extends JpaRepository<Produits, Integer>{
    
     @Query(value ="SELECT p FROM Produits p WHERE p.nom=:name")
    public  Produits findByNameProduit(@Param(value = "name")String name);
}
