/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.ClientStoryRepository;
import com.usePay.com.dao.CommercialStoryRepostory;
import com.usePay.com.entities.Souscription;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.dao.SouscriptionRepostory;
import com.usePay.com.dao.UserRepostory;
import com.usePay.com.entities.ClientStory;

import com.usePay.com.entities.User;
import com.usePay.com.entities.CommercialStory;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Autowired
    CommercialStoryRepostory commercialStoryRepostory;

    @Autowired
    ClientStoryRepository clientStoryRepository;

    @Autowired
    UserRepostory userRepository;

    @GetMapping("getSubscriptionList/{username}")
    public Object getSubscriptionList(@PathVariable(value = "username") String username) {

        try {
            return souscriptionRepository.findSouscriptionByIduser(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            HashMap map = new HashMap();
            map.put("status", "0");
            map.put("message", e.getMessage());
            return map;
        }
    }

    @PostMapping("saveSouscription")
    public Object saveSouscription(@RequestBody Souscription souscription) {
        HashMap map = new HashMap();
        CommercialStory commercialStory = new CommercialStory();
        ClientStory clientStory = new ClientStory();

        try {
            souscription.setDateSouscription(LocalDateTime.now());
            souscription.setTauxPenalite(0);
            souscription.setDuree(souscription.getDateDebut()
                    .plusMonths(souscription.getProduits().getCategorie()
                            .getPeriodeVerssement().getPeriodeMax()));

            souscription.setMontantJour(souscription.getProduits().getPrix() / (24 * souscription.getProduits()
                    .getCategorie().getPeriodeVerssement().getPeriodeMax()));

            souscription.setVersement(souscription.getProduits().getTauxPremierVerssement().getTaux() * souscription.getProduits()
                    .getPrix());

            souscription.setMontantDet(souscription.getProduits().getPrix() - souscription.getVersement());

            User user = userRepository.findUserByUsername(souscription.getUser().getUserCreator());
            commercialStory.setUser(souscription.getUser());
            commercialStory.setTransactionType("Souscription");
            commercialStory.setTransactionDate(LocalDateTime.now());
            commercialStory.setNewBalance(souscription.getVersement() + user.getSolde());
            commercialStory.setOldBalance(user.getSolde());
            commercialStory.setTransactionBalance(souscription.getVersement());

            clientStory.setNewDette(souscription.getMontantDet());
            clientStory.setOldDette(0.0);
            clientStory.setTransactionDate(LocalDateTime.now());
            clientStory.setTransactionType("Souscription");
            clientStory.setVersement(souscription.getVersement());
            clientStory.setUser(souscription.getUser());

            souscriptionRepository.save(souscription);
            commercialStoryRepostory.save(commercialStory);
            clientStoryRepository.save(clientStory);

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

    @PostMapping(value = "creditSouscription")
    public Object creditClient(@RequestBody Souscription souscription) {
        HashMap map = new HashMap();
        CommercialStory commercialStory = new CommercialStory();
        ClientStory clientStory = new ClientStory();
        double oldDette = souscription.getMontantDet();

        try {
            souscription.setMontantDet(souscription.getMontantDet() - souscription.getVersementJour());

            User commercialUser = userRepository.findUserByUsername(souscription.getUser().getUserCreator());
            double oldSolde = commercialUser.getSolde();
            commercialUser.setSolde(commercialUser.getSolde() + souscription.getVersementJour());

            commercialStory.setUser(commercialUser);
            commercialStory.setTransactionDate(LocalDateTime.now());
            commercialStory.setTransactionBalance(souscription.getVersementJour());
            commercialStory.setTransactionType("Credit");
            commercialStory.setOldBalance(oldSolde);
            commercialStory.setNewBalance(commercialUser.getSolde());

            clientStory.setNewDette(souscription.getMontantDet());
            clientStory.setOldDette(oldDette);
            clientStory.setTransactionDate(LocalDateTime.now());
            clientStory.setTransactionType("versement du jour");
            clientStory.setVersement(souscription.getVersementJour());
            clientStory.setUser(souscription.getUser());

            commercialStoryRepostory.save(commercialStory);
            userRepository.save(commercialUser);
            clientStoryRepository.save(clientStory);
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
