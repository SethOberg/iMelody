package com.example.iMelody.repository;

import com.example.iMelody.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public int insert(Customer object) {
        String sql = "insert into customer (customer_id, first_name, last_name, country, postal_code, phone, email) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        Customer customer = new Customer(500, "Jane", "Doe", "Sweden", "12345", "0709374826", "jane.doe@mail.com");

        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getCountry());
            statement.setString(5, customer.getPostalCode());
            statement.setString(6, customer.getPhoneNumber());
            statement.setString(7, customer.getEmail());

            ResultSet rs = statement.executeQuery();

        } catch(SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public int update(Customer object) {
        return 0;
    }

    @Override
    public int delete(Customer object) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public List<Customer> getCustomersByOffsetAndLimit(int offset, int limit) {
        String sql = "select * from customer offset ? limit ?";
        List<Customer> customers = new LinkedList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, limit);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("country"),
                        rs.getString("postal_code"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
                customers.add(customer);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        customers.stream()
                .forEach((customer) -> System.out.println(customer.getFirstName() + " " + customer.getLastName()));

        return customers;
    }
}
