/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.entities.Client;
import com.usePay.com.entities.Commercial;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.dao.ClientRepository;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiClient")
public class ClientRestController {

    @Autowired
    ClientRepository compteRepository;
    
      
    @GetMapping(value = "getListClient")
    public List<Client>getListCompte(){
        
        return compteRepository.findAll();
    }
    
    @PostMapping(value = "saveClient")
    public HashMap saveCompte(@RequestBody Client client) {
        HashMap map = new HashMap();
        try {

            compteRepository.save(client);
            map.put("status", "1");
            map.put("message", "Success");
            return map;
        } catch (Exception e) {
            map = new HashMap();
            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;

        }

    }
}
