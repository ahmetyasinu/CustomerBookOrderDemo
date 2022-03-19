package com.ahmetyasin.demogetir.order;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import com.ahmetyasin.demogetir.user.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OrderServiceImplTest {


    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderServiceImpl repository;


    @Test
    void findAll() {
        Order order= new Order();
        order.setPrice(222);
        order.setCustomerId(1);

        List<OrderDTO> orderDTOS = orderService.findAll(Pageable.unpaged());

        assertEquals(orderDTOS.size(), 1);
    }


    @Test
    void testSave() {
        OrderDTO orderDTO= new OrderDTO();
        orderDTO.setPrice(222);
        orderDTO.setCustomerId(1);



        OrderDTO result =orderService.save(orderDTO);

        assertEquals(result.getPrice(), orderDTO.getPrice());
    }

    @Test
    void findById() {
        long id=1;
        orderService.findById(id);
    }


    @Test
    void deleteById() {
        long id=1;
        orderService.deleteById(id);

    }


}