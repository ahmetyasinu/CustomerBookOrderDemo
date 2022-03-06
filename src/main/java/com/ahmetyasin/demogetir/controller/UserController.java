package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.User;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import com.ahmetyasin.demogetir.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "User API ")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @RequestMapping("/save")
    @PostMapping
    @ApiOperation(value = "User Entry", notes = "User Create RestApi")
    public void UserController(@RequestBody UserDto userDto) {
        userServiceImpl.save(userDto);
    }


}
