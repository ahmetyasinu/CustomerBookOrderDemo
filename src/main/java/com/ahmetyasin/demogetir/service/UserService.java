package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.User;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<UserDto> findAll();

    public UserDto findById(Long id);

    public void save(UserDto user);

    public void deleteById(Long id);

    public void update(UserDto user, Long id);
}
