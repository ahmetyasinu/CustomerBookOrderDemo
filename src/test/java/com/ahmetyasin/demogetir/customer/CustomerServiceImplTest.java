package com.ahmetyasin.demogetir.customer;

import com.ahmetyasin.demogetir.entity.Customer;
import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;
import com.ahmetyasin.demogetir.repository.ICustomerRepository;
import com.ahmetyasin.demogetir.user.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private ICustomerRepository repository;


    @Test
    void findAll() {
        Customer customer= new Customer();
        customer.setEmail("ahmetyasinuzun@getir.com");
        customer.setPassword("getir");
        customer.setUsername("ayu");

        when(repository.findAll()).thenReturn(Collections.singletonList(customer));
        List<CustomerDTO> customerDTOS = customerService.findAll();

        assertEquals(customerDTOS.size(), 1);
    }


    @Test
    void testSave() {
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setEmail("ahmetyasinuzun@getir.com");
        customerDTO.setPassword("getir");
        customerDTO.setUsername("ayu");


        Customer customerMock = mock(Customer.class);

        when(repository.save(ArgumentMatchers.any(Customer.class))).thenReturn(customerMock);
        CustomerDTO result =customerService.save(customerDTO);

        assertEquals(result.getUsername(), customerDTO.getUsername());
    }

    @Test
    void findById() {
        long id=1;
        customerService.findById(id);
    }


    @Test
    void deleteById() {
        long id=1;
        customerService.deleteById(id);

    }

    @Test
    void update() {
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setEmail("ahmetyasinuzun@getir.com");
        customerDTO.setPassword("getir");
        customerDTO.setUsername("ayu");

        customerService.update(customerDTO,customerDTO.getId());

    }
}