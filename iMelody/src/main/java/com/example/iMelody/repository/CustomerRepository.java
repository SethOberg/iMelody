package com.example.iMelody.repository;

import com.example.iMelody.models.Customer;
import com.example.iMelody.models.CustomerCountry;
import com.example.iMelody.models.CustomerGenre;

import java.util.List;

public interface CustomerRepository extends CrudRepositoryInterface<Customer, Integer> {

    /**
     * Returns a list of customer, limited based on offset and limit values.
     * @param offset
     * @param limit
     * @return List<Customer>
     */
    List<Customer> getCustomersByOffsetAndLimit(int offset, int limit);

    /**
     * Retrieves a list with the most customers.
     * @return CustomerCountry
     */
    CustomerCountry getCountryWithMostCustomers();

    /**
     * Returns a Customer based on first and last name.
     * @param firstName
     * @param lastName
     * @return Customer
     */
    Customer getByName(String firstName, String lastName);

    /**
     * Retrieves the customer with the highest spending.
     * @return Customer
     */
    Customer highestCustomerSpender();

    /**
     * Retrieves the most popular genre for a specific user.
     * @param id
     * @return CustomerGenre
     */
    CustomerGenre getMostPopularGenre(Integer id);
}
