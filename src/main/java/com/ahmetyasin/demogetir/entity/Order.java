package com.ahmetyasin.demogetir.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Login")
@ApiModel(value = "Login",description = "Login Entity")
public class Order extends BaseEntity<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "price")
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> orderItemEntities;

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer ID) {

    }


}
