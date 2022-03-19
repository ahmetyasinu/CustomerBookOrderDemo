package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;
import com.ahmetyasin.demogetir.user.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer API")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @RequestMapping("/save")
    @PostMapping
    @ApiOperation(value = "Customer Entry",notes = "Customer Create RestApi")
    public void saveCustomer(@Valid @RequestBody CustomerDTO customer){
        customerServiceImpl.save(customer);
    }

    @GetMapping("/list")
    @ApiOperation(value = "Customer Entry",notes = "Customer list RestApi")
    public ResponseEntity<List<CustomerDTO>> listCustomers() {
        // get employees from db
        List<CustomerDTO> customerDTOList = customerServiceImpl.findAll();
        return ResponseEntity.ok(customerDTOList);
    }

    @DeleteMapping("/delete/{customerId}")
    @ApiOperation(value = "Customer Entry",notes = "Customer delete RestApi")
    public String deleteCustomer(@PathVariable Long customerId) {


        customerServiceImpl.deleteById(customerId);

        return "Deleted book id - " + customerId;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Customer Entry",notes = "Customer save RestApi")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {

        customerServiceImpl.save(customerDTO);

        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping("/{customerId}")
    @ApiOperation(value = "Customer Entry",notes = "Customer get RestApi")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long customerId) {

        CustomerDTO customerDTO = customerServiceImpl.findById(customerId);

        // throw exception if null

        if (customerDTO == null) {
            throw new RuntimeException("book not found - " + customerId);
        }


        return ResponseEntity.ok(customerDTO);
    }

    @PutMapping("/update/{customerId}")
    @ApiOperation(value = "Customer Entry",notes = "Customer Update RestApi")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long customerId ,@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerServiceImpl.findById(customerId);
        if (customerId!=customer.getId()){
            throw new RuntimeException("book id not match - " + customerId);
        }
        customerServiceImpl.save(customerDTO);

        return ResponseEntity.ok(customerDTO);
    }
}
