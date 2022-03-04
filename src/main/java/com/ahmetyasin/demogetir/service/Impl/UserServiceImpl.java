package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.User;
import com.ahmetyasin.demogetir.repository.IUserRepository;
import com.ahmetyasin.demogetir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public List<User> findAll() {

        return this.userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void update(User user, int id) {
        userRepository.save(user);
    }


}
