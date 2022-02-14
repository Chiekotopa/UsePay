/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.entities.Souscription;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.dao.SouscriptionRepostory;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiSouscription")
@CrossOrigin(origins = "*")
public class SouscriptionController {

    @Autowired
    SouscriptionRepostory souscriptionRepository;

    @GetMapping("getSubscriptionList")
    public List<Souscription> getSubscriptionList() {

        try {
            return souscriptionRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    @PostMapping("saveSouscription")
    public HashMap saveSouscription(@RequestBody Souscription souscription) {
        HashMap map = new HashMap();
        try {
            souscriptionRepository.save(souscription);
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
