package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Login;

import java.util.List;

public interface UserService {

    public List<Login> findAll();
    public Login findById(int id);
    public void save(Login login);
    public void deleteById(int id);
    public void update(Login login,int id);
}
