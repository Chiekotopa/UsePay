/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usePay.com.Dao.GaleryRepository;
import com.usePay.com.Dao.ProduitsRepository;
import com.usePay.com.Entities.Produits;
import com.usePay.com.entities.Galery;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MIKE
 */
@RestController
@RequestMapping("/apiProduit")
@CrossOrigin(origins = "*")
public class ProduitControler {

    @Autowired
    ProduitsRepository produitsRepository;
    @Autowired
    GaleryRepository galeryRepository;

    String DIRECTORY = System.getProperty("user.home") + "\\Documents\\UseAndPay\\Galery";

    @PostMapping(value = "saveProduit")
    public Object SaveGalery(@RequestParam(value = "file") List<MultipartFile> imageFile, @RequestParam(value = "produit") String produit) throws JsonProcessingException {
        HashMap map = new HashMap();

        Galery galery = new Galery();
        new File(DIRECTORY).mkdirs();
        Produits produits = new ObjectMapper().readValue(produit, Produits.class);
        List<Galery> galerys = new ArrayList<>();
        if (!imageFile.isEmpty()) {
            try {
                for (MultipartFile file : imageFile) {
                    String filename = StringUtils.cleanPath(file.getOriginalFilename());
                    String extention = " ";
                    int i = filename.lastIndexOf('.');
                    if (i > 0) {
                        extention = filename.substring(i + 1);
                        extention = extention.toLowerCase();
                        System.out.println(extention);
                        if (extention.equals("jpg") || extention.equals("png") || extention.equals("jpeg")) {
                            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
                            System.out.println(DIRECTORY);
                            Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println(fileStorage + " " + filename + " " + file.getInputStream());
                            galery.setTypeFile(file.getContentType());
                            galery.setPhoto(file.getBytes());
                            galery.setFileName(filename);
                            galerys.add(galery);
                            galeryRepository.save(galery);
                            galery = new Galery();

                        } else {
                            map.put("status", "-1");
                            map.put("message", "extension is not valide");
                            return map;
                        }
                    }
                }
                produits.setGalery(galerys);
                produitsRepository.save(produits);
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
            try {
                produitsRepository.save(produits);
                map.put("status", "1");
                map.put("message", "Success");
                return map;
            } catch (Exception e) {
                map.put("status", "0");
                map.put("message", e.getMessage());
                e.printStackTrace();
                return map;
            }

        }

    }
    

    @GetMapping("getListProduit")
    public Object getListProduit() {
        HashMap map = new HashMap();

        try {

            return produitsRepository.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", "0");
            map.put("message", e.getMessage());

            return map;
        }
    }

    @DeleteMapping("deleteProduit")
    public Object deleteProduit(@RequestBody Produits produits) {
        HashMap map = new HashMap();
        Produits produits1=produitsRepository.getOne(produits.getIdProduit());
        try {
            produitsRepository.delete(produits1);
            map.put("status", "1");
            map.put("message", "Success");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", "0");
            map.put("message", e.getMessage());

            return map;
        }
    }

}
