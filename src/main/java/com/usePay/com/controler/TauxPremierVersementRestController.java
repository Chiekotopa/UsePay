/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.TauxPremierVersementRepository;
import com.usePay.com.entities.TauxPremierVerssement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/apiTauxVersement")
@CrossOrigin(origins = "*")
public class TauxPremierVersementRestController {

    @Autowired
    TauxPremierVersementRepository versementRepository;

    @PostMapping(value = "SaveTauxVersement")
    public Object SavePeriode(@RequestBody TauxPremierVerssement premierVerssement) {
        HashMap map = new HashMap();

        try {
            versementRepository.save(premierVerssement);
            map.put("status", "1");
            map.put("message", "Success");
            return map;

        } catch (Exception e) {

            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }

    @GetMapping(value = "getListTauxVersement")
    public Object getListTauxVersement() {
        HashMap map = new HashMap();
        try {

            return versementRepository.findAll();

        } catch (Exception e) {

            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }

}
