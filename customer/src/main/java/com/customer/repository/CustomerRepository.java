package com.customer.repository;

import com.customer.entity.Customer;
import com.customer.modal.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findByName (String name);
    Customer findByContactNo (String contactNo);

    Customer deleteByName (String name);
}
