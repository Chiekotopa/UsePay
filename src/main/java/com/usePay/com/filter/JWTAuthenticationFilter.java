/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usePay.com.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.usePay.com.entities.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



/**
 *
 * @author MIKE
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
     
    private final AuthenticationManager authenticationManager;
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, 
    HttpServletResponse response) throws AuthenticationException {
        Users user=null;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            user.getUsername(),
            user.getPassword()
        ));
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
    Authentication authResult) throws IOException, ServletException {
        User springUser=(User)authResult.getPrincipal();
        String jwtToken=Jwts.builder()
        .setSubject(springUser.getUsername())
        .setExpiration(new
        Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
        .claim("roles", springUser.getAuthorities())
        .compact();
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+" "+jwtToken);
        
    } 


}
     
