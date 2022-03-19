package com.ahmetyasin.demogetir.entity.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class OrderDTO extends BaseDTO<Long> {

    private Long id;
    private Integer customerId;
    private Integer price;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> orderItems;
    private Date startDate;
    private Date endDate;


    public OrderDTO() {
    }

    public OrderDTO(Long id, Integer customerId, Integer price, LocalDateTime createdAt, List<OrderItemDTO> orderItems, Date startDate, Date endDate) {
        this.id = id;
        this.customerId = customerId;
        this.price = price;
        this.createdAt = createdAt;
        this.orderItems = orderItems;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
