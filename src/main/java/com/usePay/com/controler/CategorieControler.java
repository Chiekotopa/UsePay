/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Entities.Categorie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.usePay.com.Dao.CategorieRepository;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author MIKE
 */
@RestController
@RequestMapping("/apicategorie")
@CrossOrigin(origins = "*")
public class CategorieControler {
    
    @Autowired
    CategorieRepository categorierepository;
  
    @PostMapping(value = "SaveCategorie")
    public Object SaveCategorie(@RequestBody Categorie categorie) {
        HashMap map = new HashMap();

        try {
            categorierepository.save(categorie);
            map.put("status", "1");
            map.put("message", "Success");
            return map;

        } catch (Exception e) {

            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }
 
    @GetMapping(value = "getListCategorie")
    public Object getListCategorie() {
        HashMap map = new HashMap();
        try {

            return categorierepository.findAll();

        } catch (Exception e) {

            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }
    
    @PostMapping(value = "DeleteCategorie")
    public Object DeleteCategorie(@RequestBody Categorie categorie) {
        HashMap map = new HashMap();

        try {
            categorierepository.delete(categorie);
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
