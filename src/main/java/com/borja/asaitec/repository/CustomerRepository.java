package com.borja.asaitec.repository;

import com.borja.asaitec.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer getCustomerByEmailAndName(String email, String name);
}
