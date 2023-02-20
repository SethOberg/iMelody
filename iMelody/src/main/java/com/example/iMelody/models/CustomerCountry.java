package com.example.iMelody.models;

import lombok.Data;

@Data
public class CustomerCountry {
    private String country;
    private int numberOfCustomers;

    public CustomerCountry(String country, int numCustomers) {
        this.country = country;
        this.numberOfCustomers = numCustomers;
    }
}
