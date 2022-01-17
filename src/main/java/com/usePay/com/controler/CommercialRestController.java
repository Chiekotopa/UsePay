/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.dao.CommercialRepository;
import com.usePay.com.entities.Agence;
import com.usePay.com.entities.Commercial;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiCommercial")
public class CommercialRestController {
    
    @Autowired
    CommercialRepository commercialRepository;
    
    @GetMapping(value = "getListCommercials")
    public List<Commercial>getListCommercials(){
        
        return commercialRepository.findAll();
    }
    
    @PostMapping(value = "saveCommercial")
    public HashMap saveCommercial(@RequestBody Commercial commercial) {
        HashMap map = new HashMap();
        try {

            commercialRepository.save(commercial);
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
