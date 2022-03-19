package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> orderItemEntities;

    public Order() {
    }

    public Order(Integer customerId, Integer price, Date startDate, Date endDate, List<OrderItem> orderItemEntities) {
        this.customerId = customerId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", orderItemEntities=" + orderItemEntities +
                '}';
    }
}
