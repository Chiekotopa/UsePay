/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.controler;

import com.usePay.com.entities.User;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usePay.com.entities.UsersStory;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.ArrayList;
import com.usePay.com.dao.UserRepostory;
import com.usePay.com.dao.UserStoryRepostory;

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
    UserStoryRepostory userStoryRepository;

    @GetMapping(value = "getListUserClient")
    public List<User> getListCompteClient() {
        try {
             return userRepository.findListClients();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
       
    }
    
     @GetMapping(value = "getListUserCommercial")
    public List<User> getListCompteCommercial() {
        try {
             return userRepository.findListCommercial();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
       
    }
  
    @PostMapping(value = "saveCommercial")
    public HashMap saveCommercial(@RequestBody User user) {
        HashMap map = new HashMap();
        try {
            System.out.println(user.getUsername());
            user.setCreationDate(new Date(System.currentTimeMillis()));
            user.setSolde(0.0);
            user.setTypeUser("Commercial");
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
    public Object saveClient(@RequestBody User user) {
        HashMap map = new HashMap();
        try {
            user.setCreationDate(new Date(System.currentTimeMillis()));
            user.setSolde(0.0);
            user.setTypeUser("Client");
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

    @PostMapping(value = "creditUSer")
    public Object creditClient(@RequestBody User user) {
        HashMap map = new HashMap();
        UsersStory usersStory = new UsersStory();
        User u=new User();
        double sdeCredit = user.getSolde();
        try {
            User c = userRepository.getById(user.getUsername());
            user.setSolde(c.getSolde() + user.getSolde());
            userRepository.save(user);
            usersStory.setClient(user);
            usersStory.setTransactionDate(new Date(System.currentTimeMillis()));
            usersStory.setTransactionBalance(sdeCredit);
            usersStory.setTransactionType("Credit");
            usersStory.setOldBalance(c.getSolde());
            usersStory.setNewBalance(user.getSolde());
            userStoryRepository.save(usersStory);
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
    public List<UsersStory> getListStoryClient(@RequestBody User user) {   
        List<UsersStory> usersStorys=new ArrayList<>();
        try {
            usersStorys=userStoryRepository.findStoryByIduser(user.getUsername());
            return   usersStorys;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
