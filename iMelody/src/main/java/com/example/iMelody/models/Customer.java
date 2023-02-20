package com.example.iMelody.models;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String email;
}
