package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "User")
@ApiModel(value = "User",description = "Login Entity")
public class User extends BaseEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @ApiModelProperty(value = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String username, String password) {
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
