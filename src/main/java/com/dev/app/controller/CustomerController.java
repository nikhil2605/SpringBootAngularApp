package com.dev.app.controller;

import com.dev.app.model.Customer;
import com.dev.app.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(value = "*")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerDB = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDB);
    }

    @PutMapping(value = "/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId,@RequestBody Customer customer){
        Customer customerDB = customerService.updateCustomerById(customerId,customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDB);
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId){
        Customer customerDB = customerService.getCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDB);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId){
        Customer customerDB = customerService.deleteCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDB);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customerlist = customerService.getAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(customerlist);
    }




}
