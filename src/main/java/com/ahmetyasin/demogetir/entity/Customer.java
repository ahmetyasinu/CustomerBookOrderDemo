package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "customer")
@ApiModel(value = "customer", description = "customer Entity")
public class Customer extends BaseEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @ApiModelProperty(value = "username")
    private String username;

    @Column(name = "password")
    @ApiModelProperty(value = "password")
    private String password;

    @Column(name = "email")
    @ApiModelProperty(value = "email")
    private String email;

    public Customer() {
    }

    public Customer(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public Long getID() {
        return this.id;
    }

    @Override
    public void setID(Long ID) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
