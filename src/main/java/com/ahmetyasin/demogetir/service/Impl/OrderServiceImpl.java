package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import com.ahmetyasin.demogetir.entity.dto.StatisticDto;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.IOrderRepository;
import com.ahmetyasin.demogetir.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    IOrderRepository repository;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);


    @Override
    public List<OrderDTO> findAll(Pageable pageable) {
        logger.info("Finding all {} datas.", Order.class);

        List<Order> orderList = (List<Order>) this.repository.findAll(pageable);
        return MapperHelper.convertAll(orderList, OrderDTO.class);
    }

    @Override
    public OrderDTO findById(Long id) {
        logger.info("Finding by id {} datas.", Order.class);

        Optional<Order> result = repository.findById(id);
        Order order = null;

        if (result.isPresent()) {
            order = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find Order id - " + id);
        }

        return MapperHelper.convert(order, OrderDTO.class);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        logger.info("save all {} datas.", Order.class);

        Order order = MapperHelper.convertBack(orderDTO, Order.class);
        repository.save(order);

    }

    @Override
    public void deleteById(Long id) {
        logger.info("delete all {} datas.", Order.class);

        repository.deleteById(id);

    }

    @Override
    public List<OrderDTO> betweenDates(Date startDate, Date endDate) {

        return MapperHelper.convertAll(repository.betweenDates(startDate, endDate), OrderDTO.class);
    }
    @Override
    public List<StatisticDto> monthlyStatistic(Long id) {

        return repository.getMonthlyStatistics(id);
    }


}
