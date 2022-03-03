package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Login;
import com.ahmetyasin.demogetir.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositoryInterface userRepository;


    @Override
    public List<Login> findAll() {

        return this.userRepository.findAll();
    }

    @Override
    public Login findById(int id) {
        Optional<Login> result = userRepository.findById(id);
        Login login = null;

        if (result.isPresent()) {
            login = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return login;
    }

    @Override
    public void save(Login login) {
        userRepository.save(login);

    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void update(Login login, int id) {
        userRepository.save(login);
    }


}
