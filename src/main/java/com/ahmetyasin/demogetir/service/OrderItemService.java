package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.OrderItem;
import com.ahmetyasin.demogetir.entity.dto.OrderItemDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {

    public List<OrderItemDTO> findAll(Pageable pageable);
    public OrderItemDTO findById(Long id);
    public void save(OrderItemDTO orderItem);
    public void deleteById(Long id);
    public void update(OrderItemDTO orderItem, Long id);

}
