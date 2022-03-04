package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.OrderItem;
import com.ahmetyasin.demogetir.repository.IOrderItemRepository;
import com.ahmetyasin.demogetir.repository.IOrderRepository;
import com.ahmetyasin.demogetir.service.OrderItemService;
import com.ahmetyasin.demogetir.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    IOrderItemRepository repository;


    @Override
    public List<OrderItem> findAll() {

        return this.repository.findAll();
    }

    @Override
    public OrderItem findById(int id) {
        Optional<OrderItem> result = repository.findById(id);
        OrderItem orderItem = null;

        if (result.isPresent()) {
            orderItem = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return orderItem;
    }

    @Override
    public void save(OrderItem orderItem) {
        repository.save(orderItem);

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void update(OrderItem orderItem, int id) {
        repository.save(orderItem);
    }


}
