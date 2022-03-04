package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {

    public List<OrderItem> findAll();
    public OrderItem findById(int id);
    public void save(OrderItem orderItem);
    public void deleteById(int id);
    public void update(OrderItem orderItem, int id);

}
