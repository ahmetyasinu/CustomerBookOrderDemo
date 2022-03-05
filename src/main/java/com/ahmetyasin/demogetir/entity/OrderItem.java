package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orderItem")
@ApiModel(value = "orderItem",description = "Login Entity")
public class OrderItem extends BaseEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "quantity")
    private Integer quantity;
    @NotNull
    @Column(name = "price")
    private Double price;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id",insertable = false,updatable = false)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id",insertable = false,updatable = false)
    private Book book;


    @Override
    public Long getID() {
        return this.id;
    }

    @Override
    public void setID(Long ID) {

    }


}
