package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.repository.IOrderRepository;
import com.ahmetyasin.demogetir.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    IOrderRepository repository;


    @Override
    public List<Order> findAll() {

        return this.repository.findAll();
    }

    @Override
    public Order findById(int id) {
        Optional<Order> result = repository.findById(id);
        Order order = null;

        if (result.isPresent()) {
            order = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return order;
    }

    @Override
    public void save(Order order) {
        repository.save(order);

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void update(Order order, int id) {
        repository.save(order);
    }


}
