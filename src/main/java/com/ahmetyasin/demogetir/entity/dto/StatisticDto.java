package com.ahmetyasin.demogetir.entity.dto;



public class StatisticDto {

    private Integer orderCount;
    private Integer bookCount;
    private Integer amount;

    public StatisticDto() {
    }
    public StatisticDto(Integer orderCount, Integer bookCount, Integer amount) {
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
}
