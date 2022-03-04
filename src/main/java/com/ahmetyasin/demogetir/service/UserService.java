package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void deleteById(int id);
    public void update(User user, int id);
}
