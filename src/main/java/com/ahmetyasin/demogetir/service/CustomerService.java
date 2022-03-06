package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.Customer;
import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    public List<CustomerDTO> findAll();
    public CustomerDTO findById(Long id);
    public void save(CustomerDTO customer);
    public void deleteById(Long id);
    public void update(CustomerDTO customer, Long id);

}
