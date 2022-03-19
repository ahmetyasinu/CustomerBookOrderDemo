package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    public List<CustomerDTO> findAll();

    public CustomerDTO findById(Long id);

    public CustomerDTO save(CustomerDTO customer);

    public void deleteById(Long id);

    public void update(CustomerDTO customer, Long id);

}
