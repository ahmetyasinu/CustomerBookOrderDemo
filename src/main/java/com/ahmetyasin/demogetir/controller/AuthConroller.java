package com.ahmetyasin.demogetir.controller;


import com.ahmetyasin.demogetir.auth.TokenManager;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import com.ahmetyasin.demogetir.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthConroller {

    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private AuthenticationManager authenticationManager;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDto user) {

        try {
            logger.info("Username and Password Contol are starting");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            return ResponseEntity.ok(tokenManager.generateToken(user.getUsername()));
        } catch (Exception e) {
            logger.error("Username and Password Contol Error");

            throw e;
        }
    }


}
