package com.example.iMelody.repository;

import com.example.iMelody.models.Customer;
import com.example.iMelody.models.CustomerCountry;
import com.example.iMelody.models.CustomerGenre;

import java.util.List;

public interface CustomerRepository extends CrudRepositoryInterface<Customer, Integer> {
    List<Customer> getCustomersByOffsetAndLimit(int offset, int limit);
    CustomerCountry getCountryWithMostCustomers();

    CustomerGenre getMostPopularGenre(Integer id);
}
