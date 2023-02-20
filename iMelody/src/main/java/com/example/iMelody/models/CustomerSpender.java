package com.example.iMelody.models;

import lombok.Data;

@Data
public class CustomerSpender {
    private int customerId;
    private String firstName;
    private String lastName;
    private double totalSpent;

    public CustomerSpender(int customerId, String firstName, String lastName, double totalSpent) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSpent = totalSpent;
    }
}
