package com.example.iMelody.repository;

import com.example.iMelody.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    Customer save(Customer customer);


}
