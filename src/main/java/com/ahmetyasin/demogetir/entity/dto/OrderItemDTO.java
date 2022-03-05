package com.ahmetyasin.demogetir.entity.dto;

public class OrderItemDTO extends BaseDTO<Long> {

  private Long id;
  private String name;
  private Integer price;
  private Integer pageSize;
  private Integer stock;

  public OrderItemDTO() {
  }

  public OrderItemDTO(Long id, String name, Integer price, Integer pageSize, Integer stock) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.pageSize = pageSize;
    this.stock = stock;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }
}
