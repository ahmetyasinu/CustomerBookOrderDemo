package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.Customer;
import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import com.ahmetyasin.demogetir.service.Impl.CustomerServiceImpl;
import com.ahmetyasin.demogetir.service.Impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "Order API")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping("/save")
    @PostMapping
    @ApiOperation(value = "Order Entry",notes = "Order Create RestApi")
    public void orderCreate(@RequestBody OrderDTO order){
        orderService.save(order);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Order Entry",notes = "Order find by id RestApi")
    public OrderDTO getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/list")
    @ApiOperation(value = "Order Entry",notes = "Order list RestApi")
    public List<OrderDTO> findAll(Pageable pageable) {
        return orderService.findAll(pageable);
    }

    //@GetMapping("/betweendate/{startDate}/{endDate}")
    //public List<OrderDTO> getOrdersBetweenGivenDates(@PathVariable LocalDateTime startDate,@PathVariable LocalDateTime endDate) {
      //  return orderService.betweenDates(startDate.toString(), endDate.toString());
    //}
}
