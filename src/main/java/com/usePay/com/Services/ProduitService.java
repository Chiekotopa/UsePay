/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.usePay.com.Dao.ProduitsRepository;
import com.usePay.com.Entities.Produits;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MIKE
 */

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class ProduitService {
    @Autowired
    ProduitsRepository produitsRepository;
    
    //api qui permet d'enregistrer une liste de produits
    @RequestMapping(value = "/saveProduits", method = RequestMethod.POST)
        public void saveEtape(@RequestBody List<Produits> produits) throws JsonProcessingException, IOException {
        for (Produits prdt : produits) {
        produitsRepository.save(prdt);
        }
    }
    
    //api qui liste les produits 
    @RequestMapping(value = "/getProduits", method = RequestMethod.GET)
    public  List<Produits>getListProduits(){
        return produitsRepository.findAll(); 
    }
    
    //api qui supprime un produits
    @RequestMapping(value = "/deleteProduits", method = RequestMethod.POST)
        public void deleteActualite(@RequestBody Produits produits ) {
        produitsRepository.delete(produits);
    }
}
