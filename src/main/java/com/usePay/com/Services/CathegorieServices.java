/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.Services;

import com.usePay.com.Entities.Cathegorie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.usePay.com.Dao.CathegorieRepository;

/**
 *
 * @author MIKE
 */
@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class CathegorieServices {
    
     @Autowired
    CathegorieRepository cathegorierepository;
  
    @RequestMapping(value = "/getTypesProduits", method = RequestMethod.GET)
    public  List<Cathegorie>getListTypesProduits(){
        return cathegorierepository.findAll(); 
    }
    
    @RequestMapping(value = "/deleteTypesProduits", method = RequestMethod.POST)
        public void deleteActualite(@RequestBody Cathegorie typesproduits ) {
        cathegorierepository.delete(typesproduits);
       
    }
}
