/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.GaleryRepository;
import com.usePay.com.Dao.ProduitsRepository;
import com.usePay.com.Entities.Produits;
import com.usePay.com.entities.Galery;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    ProduitsRepository produitsRepository;

    String DIRECTORY = System.getProperty("user.home") + "//Documents//UseAndPay//Galery";

    @PostMapping(value = "saveGalery/{produitName}")
    public Object SaveGalery(@RequestParam(value = "file") MultipartFile imageFile, @PathVariable(value = "produitName") String produitName) {
        HashMap map = new HashMap();
        Galery galery = new Galery();
        File filedirectory = new File(DIRECTORY);
        boolean res = filedirectory.mkdir();
        if (res) {
            if (!imageFile.isEmpty()) {
                try {

                    String filename = StringUtils.cleanPath(imageFile.getOriginalFilename());
                    Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
                    System.out.println(DIRECTORY);
                    Files.copy(imageFile.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(fileStorage + " " + filename + " " + imageFile.getInputStream());

                    Produits produit = produitsRepository.findByNameProduit(produitName);
                    galery.setProduit(produit);
                    //galeryRepository.save(galery);
                    map.put("status", "1");
                    map.put("message", "Success");
                    return map;

                } catch (Exception e) {

                    map.put("status", "0");
                    map.put("message", e.getMessage());
                    e.printStackTrace();
                    return map;
                }
            } else {
                map.put("status", "0");
                map.put("message", "fichier vide!");
                return map;

            }
        }else{
          return "repertoire no exist "+ DIRECTORY;
    }
}

@PostMapping(value = "deleteGalery")
        public Object SavePeriode(@RequestBody Galery galery) {
        HashMap map = new HashMap();

        try {
            galeryRepository.delete(galery);
            map.put("status", "1");
            map.put("message", "Success");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", "0");
            map.put("message", e.getMessage());
            e.printStackTrace();
            return map;
        }
    }
}
