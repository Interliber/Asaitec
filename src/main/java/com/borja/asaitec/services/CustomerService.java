package com.borja.asaitec.services;

import com.borja.asaitec.model.Customer;
import com.borja.asaitec.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }
    public Integer customerExists(Customer customer){
        Customer customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(), customer.getName());
        return customer1 != null ? customer1.getId() : null;
    }
}
