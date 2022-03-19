package com.ahmetyasin.demogetir.entity;

import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Book")
@ApiModel(value = "Book", description = "Book Entity")
public class Book extends BaseEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Book Name Null")
    private String name;

    @Column(name = "author")
    @NotNull
    private String author;

    @Column(name = "pageSize")
    private Integer pageSize;


    @Column(name = "price")
    private Integer price;

    @Column(name = "stock")
    @PositiveOrZero
    private Integer stock;


    public Book() {
    }

    public Book(@NotBlank(message = "Book Name Null") String name, @NotNull String author, Integer pageSize, Integer price, @PositiveOrZero Integer stock) {
        this.name = name;
        this.author = author;
        this.pageSize = pageSize;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public void setID(Long ID) {
        this.id = ID;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pageSize=" + pageSize +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
