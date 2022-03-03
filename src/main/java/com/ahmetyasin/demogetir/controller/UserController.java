package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.Login;
import com.ahmetyasin.demogetir.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Benim Pet API dökumantasyonum")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/save")
    @PostMapping
    @ApiOperation(value = "Login Entry",notes = "Login Create RestApi")
    public void UserController(@RequestBody Login login){
        userServiceImpl.save(login);
    }
}
