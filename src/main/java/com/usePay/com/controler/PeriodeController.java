/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.PeriodeVerssementRepository;
import com.usePay.com.entities.PeriodeVerssement;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chieko Topa
 */
@RestController
@RequestMapping("/apiPeriode")
@CrossOrigin(origins = "*")
public class PeriodeController {
   
    @Autowired
    PeriodeVerssementRepository verssementRepository;
    
    @PostMapping(value = "SavePeriode")
    public Object SavePeriode(@RequestBody PeriodeVerssement periodeVerssement){
        HashMap map=new HashMap();
        
        try {
            verssementRepository.save(periodeVerssement);
            map.put("status", "1");
            map.put("message", "Success");
            return map;
            
        } catch (Exception e) {
           
            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }
    
    
    @GetMapping(value = "getPeriode")
    public Object getListTauxVersement() {
        HashMap map = new HashMap();
        try {

            return verssementRepository.findAll();

        } catch (Exception e) {

            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }
    
}
