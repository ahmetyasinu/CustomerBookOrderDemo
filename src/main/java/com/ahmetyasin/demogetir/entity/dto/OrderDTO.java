package com.ahmetyasin.demogetir.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

  private Integer id;
  private Integer customerId;
  private Integer price;
  private LocalDateTime createdAt;
  private List<OrderItemDTO> orderItems;

  public OrderDTO() {
  }

  public OrderDTO(Integer id, Integer customerId, Integer price, LocalDateTime createdAt, List<OrderItemDTO> orderItems) {
    this.id = id;
    this.customerId = customerId;
    this.price = price;
    this.createdAt = createdAt;
    this.orderItems = orderItems;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
