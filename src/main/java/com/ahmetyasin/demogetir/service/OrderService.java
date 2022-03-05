package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<OrderDTO> findAll(Pageable pageable);
    public OrderDTO findById(Long id);
    public void save(OrderDTO order);
    public void deleteById(Long id);
   // public List<OrderDTO> betweenDates(String startDate,String endDate);

}
