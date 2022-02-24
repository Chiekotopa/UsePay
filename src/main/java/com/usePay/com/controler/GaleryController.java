/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.GaleryRepository;
import com.usePay.com.Dao.ProduitsRepository;
import com.usePay.com.entities.Galery;
import java.io.File;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/apiGalery")
@CrossOrigin(origins = "*")
public class GaleryController {

    @Autowired
    GaleryRepository galeryRepository;

    @Autowired
    ProduitsRepository produitsRepository;
   public static String DIRECTORY = System.getProperty("user.home") + "\\Documents\\UseAndPay\\Galery";

//    @GetMapping("getGalery")
//    public Object downloadFile() {
//        Galery galery = galeryRepository.getOne(2);
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(galery.getTypeFile()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + galery.getFileName() + "\"")
//                .body(new ByteArrayResource(galery.getPhoto()));
//    }
   
    @DeleteMapping(value = "deleteGalery")
    public Object deleteGalery(@RequestBody Galery galery) {
        HashMap map = new HashMap();

        try {
            galery = galeryRepository.getOne(galery.getIdPhoto());
            File file = new File(DIRECTORY+"\\"+galery.getFileName());
            file.delete();
            galeryRepository.delete(galery);
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
