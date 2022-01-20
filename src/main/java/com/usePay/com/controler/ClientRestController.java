/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.entities.Client;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.dao.ClientRepository;
import com.usePay.com.dao.ClientStoryRepository;
import com.usePay.com.entities.ClientStory;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiClient")
@CrossOrigin(origins = "*")
public class ClientRestController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientStoryRepository clientStoryRepository;

    @GetMapping(value = "getListClient")
    public List<Client> getListCompte() {
        try {
             return clientRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
       
    }

    @PostMapping(value = "saveClient")
    public HashMap saveClient(@RequestBody Client client) {
        HashMap map = new HashMap();
        try {

            client.setCreationDate(new Date(System.currentTimeMillis()));
            client.setSolde(0);
            clientRepository.save(client);
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

    @PostMapping(value = "creditClient")
    public HashMap creditClient(@RequestBody Client client) {
        HashMap map = new HashMap();
        ClientStory clientStory = new ClientStory();
        double sdeCredit = client.getSolde();
        try {
            Client c = clientRepository.getById(client.getIdClient());
            client.setSolde(c.getSolde() + client.getSolde());
            clientRepository.save(client);
            clientStory.setClient(client);
            clientStory.setTransactionDate(new Date(System.currentTimeMillis()));
            clientStory.setTransactionSolde(sdeCredit);
            clientStory.setTransactionType("Credit");
            clientStoryRepository.save(clientStory);
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

    @PostMapping(value = "getListStoryClient")
    public List<ClientStory> getListStoryClient(@RequestBody Client client) {   
        try {
            return clientStoryRepository.findStoryByIdClient(client.getIdClient());  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
