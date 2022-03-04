package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer findById(int id);
    public void save(Customer customer);
    public void deleteById(int id);
    public void update(Customer customer, int id);

}
