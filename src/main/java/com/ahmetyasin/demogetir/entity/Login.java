package com.ahmetyasin.demogetir.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "Login")
@ApiModel(value = "Login",description = "Login Entity")
public class Login  extends BaseEntity<Integer> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @ApiModelProperty(value = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Login() {
    }

    public Login(String username, String password) {
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
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer ID) {

    }


}
