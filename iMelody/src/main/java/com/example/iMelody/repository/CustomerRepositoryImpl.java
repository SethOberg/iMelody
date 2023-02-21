package com.example.iMelody.repository;

import com.example.iMelody.models.Customer;
import com.example.iMelody.models.CustomerCountry;
import com.example.iMelody.models.CustomerGenre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
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
        ArrayList<Customer> customers = new ArrayList<>();
        try(var connection = DriverManager.getConnection(url, username, password)){
            String getAllCustomersQuery = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer";
            PreparedStatement statement = connection.prepareStatement(getAllCustomersQuery);
            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getInt("customer_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("country"),
                        resultSet.getString("postal_code"), resultSet.getString("phone"),
                        resultSet.getString("email")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
            return customers;
    }

    @Override
    public Customer getById(int id) {
        Customer customer = null;
        try(var connection = DriverManager.getConnection(url, username, password)){
            String getCustomerByIdQuery = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE customer_id = ?";

            PreparedStatement statement = connection.prepareStatement(getCustomerByIdQuery);
            statement.setInt(1, id);
            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                customer = new Customer(resultSet.getInt("customer_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("country"),
                        resultSet.getString("postal_code"), resultSet.getString("phone"),
                        resultSet.getString("email"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer getByName(String firstName, String lastName) {
        Customer customer = null;
        try(var connection = DriverManager.getConnection(url, username, password)){
            String getCustomerByNameQuery = "SELECT customer_id, first_name, last_name, country, postal_code, phone, email FROM customer WHERE first_name LIKE ? AND last_name LIKE ?";
            PreparedStatement statement = connection.prepareStatement(getCustomerByNameQuery);
            statement.setString(1, "%" + firstName + "%");
            statement.setString(2, "%" + lastName + "%");

            var resultSet = statement.executeQuery();
            while (resultSet.next()){
                customer = new Customer(resultSet.getInt("customer_id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("country"),
                        resultSet.getString("postal_code"), resultSet.getString("phone"),
                        resultSet.getString("email"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public int insert(Customer customer) {
        String sql = "insert into customer (first_name, last_name, country, postal_code, phone, email)" +
                "values (?, ?, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getCountry());
            statement.setString(4, customer.getPostalCode());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getEmail());

            return statement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Customer customer) {
        String sql = "update customer set first_name = ?, last_name = ?, country = ?," +
                " postal_code = ?, phone = ?, email = ? where customer_id = ?";

        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getCountry());
            statement.setString(4, customer.getPostalCode());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getEmail());
            statement.setInt(7, customer.getId());

            return statement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }

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

    @Override
    public CustomerCountry getCountryWithMostCustomers() {
        CustomerCountry customerCountry = null;
        try(var connection = DriverManager.getConnection(url, username, password)){
            String getCountryWithMostCustomersQuery = "SELECT country, COUNT(*) AS customer_count\n" +
                    "FROM customer\n" +
                    "GROUP BY country\n" +
                    "ORDER BY customer_count DESC\n" +
                    "LIMIT 1;";
            PreparedStatement statement = connection.prepareStatement(getCountryWithMostCustomersQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                customerCountry = new CustomerCountry(resultSet.getString("country"), resultSet.getInt("customer_count"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customerCountry;
    }

    @Override
    public CustomerGenre getMostPopularGenre(Integer id) {
        CustomerGenre customerGenre = null;
        ArrayList<String> genreNames = new ArrayList<>();
        String getMostPopularGenreQuery = "SELECT genre.name, COUNT(*) as genre_count\n" +
                "FROM invoice\n" +
                "INNER JOIN customer ON invoice.customer_id = customer.customer_id\n" +
                "INNER JOIN invoice_line ON invoice.invoice_id = invoice_line.invoice_id\n" +
                "INNER JOIN track ON track.track_id = invoice_line.track_id\n" +
                "INNER JOIN genre ON genre.genre_id = track.genre_id\n" +
                "WHERE customer.customer_id = ?\n" +
                "GROUP BY genre.name\n" +
                "ORDER BY genre_count DESC\n" +
                "FETCH FIRST 1 ROWS WITH TIES;";

        try (var connection = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = connection.prepareStatement(getMostPopularGenreQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                genreNames.add(rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  new CustomerGenre(id, genreNames);
    }
}
