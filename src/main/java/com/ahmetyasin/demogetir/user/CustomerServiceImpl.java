package com.ahmetyasin.demogetir.user;

import com.ahmetyasin.demogetir.entity.Customer;
import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.ICustomerRepository;
import com.ahmetyasin.demogetir.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    ICustomerRepository repository;
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Override
    public List<CustomerDTO> findAll() {
        logger.info("Finding all {} datas.", Customer.class);
        List<Customer> customers = this.repository.findAll();
        return MapperHelper.convertAll(customers, CustomerDTO.class);
    }

    @Override
    public CustomerDTO findById(Long id) {

        logger.info("Finding by {} datas.", Customer.class);

        Optional<Customer> result = repository.findById(id);
        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + id);
        }

        return MapperHelper.convert(customer, CustomerDTO.class);
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        logger.info("Save by {} datas.", Customer.class);

        repository.save(MapperHelper.convertBack(customerDTO, Customer.class));
        return customerDTO;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        logger.info("Delete by {} datas.", Customer.class);

        repository.deleteById(id);

    }

    @Override
    @Transactional
    public void update(CustomerDTO customer, Long id) {
        logger.info("Finding and update by {} datas.", Customer.class);

        if (customer.getId() != id) {
            throw new RuntimeException("Id ler eşleşmedi.");
        }

        this.repository.save(MapperHelper.convertBack(customer, Customer.class));

    }


}
