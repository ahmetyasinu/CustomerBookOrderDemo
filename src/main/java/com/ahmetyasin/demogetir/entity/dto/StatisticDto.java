package com.ahmetyasin.demogetir.entity.dto;


public class StatisticDto extends BaseDTO<Long> {
    private Long id;
    private Integer orderCount;
    private Integer bookCount;
    private Integer amount;

    public StatisticDto() {
    }

    public StatisticDto(Long id, Integer orderCount, Integer bookCount, Integer amount) {
        this.id = id;
        this.orderCount = orderCount;
        this.bookCount = bookCount;
        this.amount = amount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
