/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.Dao.ClientStoryRepository;
import com.usePay.com.entities.Users;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.entities.CommercialStory;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.ArrayList;
import com.usePay.com.dao.UserRepostory;
import java.time.LocalDateTime;
import com.usePay.com.dao.CommercialStoryRepostory;
import com.usePay.com.entities.ClientStory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author chiek
 */
@RestController
@RequestMapping("/apiUser")
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    UserRepostory userRepository;

    @Autowired
    CommercialStoryRepostory commercialStoryRepostory;

    @Autowired
    ClientStoryRepository clientStoryRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "getListUserClient")
    public List<Users> getListCompteClient() {
        try {
            return userRepository.findListClients();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping(value = "getListUserCommercial")
    public List<Users> getListCompteCommercial() {
        try {
            return userRepository.findListCommercial();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @PostMapping(value = "saveCommercial")
    public HashMap saveCommercial(@RequestBody Users user) {
        HashMap map = new HashMap();
        try {
            System.out.println(user.getUsername());
            user.setCreationDate(LocalDateTime.now());
            user.setSolde(0.0);
            user.setTypeUser("Commercial");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            map.put("status", "1");
            map.put("message", "Success");
            return map;
        } catch (Exception e) {
            map = new HashMap();
            map.put("status", "0");
            map.put("message", e.getMessage());
            System.out.println(map);
            return map;
        }

    }

    @PostMapping(value = "saveClient")
    public Object saveClient(@RequestBody Users user) {
        HashMap map = new HashMap();
        try {
            user.setCreationDate(LocalDateTime.now());
            user.setSolde(0.0);
            user.setTypeUser("Client");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            userRepository.save(user);
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

    @PostMapping(value = "getListStoryClient")
    public List<ClientStory> getListStoryClient(@RequestBody Users user) {
        List<ClientStory> usersStorys = new ArrayList<>();
        try {
            usersStorys = clientStoryRepository.findStoryByIduser(user.getUsername());
            return usersStorys;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping(value = "getListStoryCommercial")
    public List<CommercialStory> getListStoryCommercial(@RequestBody Users user) {
        List<CommercialStory> usersStorys = new ArrayList<>();
        try {
            usersStorys = commercialStoryRepostory.findStoryByIduser(user.getUsername());
            return usersStorys;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
