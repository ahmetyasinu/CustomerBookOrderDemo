package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.Customer;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.ICustomerRepository;
import com.ahmetyasin.demogetir.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    ICustomerRepository repository;
    MapperHelper orikaMapper;


    @Override
    public List<Customer> findAll() {
        List<Customer> customers=this.repository.findAll();
        return customers;
    }

    @Override
    public Customer findById(int id) {



        Optional<Customer> result = repository.findById(id);
        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return customer;
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void update(Customer customer, int id) {
        repository.save(customer);
    }


}
