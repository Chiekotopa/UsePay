/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.GaleryRepository;
import com.usePay.com.entities.Galery;
import com.usePay.com.entities.PeriodeVerssement;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiGalery")
@CrossOrigin(origins = "*")
public class GaleryController {
    
    @Autowired
    GaleryRepository galeryRepository;
    
     @PostMapping(value = "saveGalery")
    public Object SaveGalery(@RequestBody Galery galery){
        HashMap map=new HashMap();
        
        try {
            galeryRepository.save(galery);
            map.put("status", "1");
            map.put("message", "Success");
            return map;
            
        } catch (Exception e) {
           
            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }
    
    
    @PostMapping(value = "deleteGalery")
    public Object SavePeriode(@RequestBody Galery galery){
        HashMap map=new HashMap();
        
        try {
            galeryRepository.delete(galery);
            map.put("status", "1");
            map.put("message", "Success");
            return map;
            
        } catch (Exception e) {
           
            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }
}
