/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.entities.Agence;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.dao.AgenceRepostory;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiAgence")
@CrossOrigin(origins = "*")
public class AgenceRestController {

    @Autowired
    AgenceRepostory agenceRepository;

    @GetMapping(value = "getlistAgences")
    public Object getlistAgents() {
        HashMap map = new HashMap();
        try {
        return agenceRepository.findAll();
           
        } catch (Exception e) {
            map = new HashMap();
            map.put("status", "0");
            map.put("message", e.getMessage());
            e.printStackTrace();
            return map;

        }

    }

    @PostMapping(value = "saveAgence")
    public Object saveAgent(@RequestBody Agence agence) {
        HashMap map = new HashMap();
        try {

            agenceRepository.save(agence);
            map.put("status", "1");
            map.put("message", "Success");
            return map;
        } catch (Exception e) {
            map = new HashMap();
            map.put("status", "0");
            map.put("message", e.getMessage());
            e.printStackTrace();
            return map;

        }

    }

}
