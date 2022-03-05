package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "customer")
@ApiModel(value = "customer",description = "customer Entity")
public class Customer extends BaseEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @ApiModelProperty(value = "username")
    private String username;

    @Column(name = "password")
    @ApiModelProperty(value = "password")
    private String password;

    public Customer() {
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Long getID() {
        return this.id;
    }

    @Override
    public void setID(Long ID) {

    }


}
