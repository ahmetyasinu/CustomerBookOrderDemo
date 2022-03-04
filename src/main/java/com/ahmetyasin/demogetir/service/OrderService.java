package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<Order> findAll();
    public Order findById(int id);
    public void save(Order order);
    public void deleteById(int id);
    public void update(Order order, int id);

}
