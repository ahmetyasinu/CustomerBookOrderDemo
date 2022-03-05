package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@ApiModel(value = "order",description = "order Entity")
public class Order extends BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "price")
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> orderItemEntities;

    public Order() {
    }

    public Order(Long id, Integer customerId, Integer price, List<OrderItem> orderItemEntities) {
        this.id = id;
        this.customerId = customerId;
        this.price = price;
        this.orderItemEntities = orderItemEntities;
    }

    @Override
    public Long getID() {
        return this.id;
    }

    @Override
    public void setID(Long ID) {
        this.id=id;

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

    public List<OrderItem> getOrderItemEntities() {
        return orderItemEntities;
    }

    public void setOrderItemEntities(List<OrderItem> orderItemEntities) {
        this.orderItemEntities = orderItemEntities;
    }
}
