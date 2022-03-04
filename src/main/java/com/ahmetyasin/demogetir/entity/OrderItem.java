package com.ahmetyasin.demogetir.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Login")
@ApiModel(value = "Login",description = "Login Entity")
public class OrderItem extends BaseEntity<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

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
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer ID) {

    }


}
