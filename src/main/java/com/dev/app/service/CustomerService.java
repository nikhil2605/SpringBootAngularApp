package com.dev.app.service;

import com.dev.app.model.Customer;
import com.dev.app.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer saveCustomer(Customer customer){
        customerRepo.save(customer);
        return customer;
    }

    public Customer getCustomerById(Integer customerId){
        Customer customer = customerRepo.findById(customerId).orElse(null);
        return customer;
    }

    public Customer deleteCustomerById(Integer customerId){
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if(customer!=null){
            customerRepo.delete(customer);
        }
        return customer;
    }

    public Customer updateCustomerById(Integer customerId,Customer newCustomer){
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if(customer!=null){
            customer.setCustomerFirstName(newCustomer.getCustomerFirstName());
            customer.setCustomerMiddleName(newCustomer.getCustomerMiddleName());
            customer.setCustomerLastName(newCustomer.getCustomerLastName());
            customer.setCustomerGender(newCustomer.getCustomerGender());
            customerRepo.save(customer);
        }
        return customer;
    }

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }




}


