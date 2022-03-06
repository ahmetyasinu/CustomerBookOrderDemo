package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import com.ahmetyasin.demogetir.entity.dto.StatisticDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {

    public List<OrderDTO> findAll(Pageable pageable);
    public OrderDTO findById(Long id);
    public void save(OrderDTO order);
    public void deleteById(Long id);
    public List<OrderDTO> betweenDates(Date startDate, Date endDate);
    public List<StatisticDto> monthlyStatistic(Long id) ;


    }
