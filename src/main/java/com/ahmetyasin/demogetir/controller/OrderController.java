package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import com.ahmetyasin.demogetir.user.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "Order API")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping("/save")
    @PostMapping
    @ApiOperation(value = "Order Entry", notes = "Order Create RestApi")
    public void orderCreate(@Valid @RequestBody OrderDTO order) {
        orderService.save(order);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Order Entry", notes = "Order find by id RestApi")
    public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "Order Entry", notes = "Order list RestApi")
    public ResponseEntity<List<OrderDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(pageable));
    }

    @GetMapping("/betweendate/{startDate}/{endDate}")
    public ResponseEntity<List<OrderDTO>> getOrdersBetweenGivenDates(@PathVariable Date startDate, @PathVariable Date endDate) {
        return ResponseEntity.ok(orderService.betweenDates(startDate, endDate));
    }
}
