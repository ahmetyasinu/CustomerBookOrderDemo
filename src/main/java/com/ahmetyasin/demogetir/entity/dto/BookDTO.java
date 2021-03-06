package com.ahmetyasin.demogetir.entity.dto;

public class BookDTO extends BaseDTO<Long> {

    private Long id;
    private String name;
    private String author;
    private Integer pageSize;
    private Integer price;
    private Integer stock;

    public BookDTO() {
    }

    public BookDTO(Long id, String name, String author, Integer price, Integer pageSize, Integer stock) {
        this.id = id;
        this.name = name;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
