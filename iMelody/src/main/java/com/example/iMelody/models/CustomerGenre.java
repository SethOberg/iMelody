package com.example.iMelody.models;

import lombok.Data;

import java.util.List;

@Data
public class CustomerGenre {
    private int customerId;
    private List<String> genre;

    public CustomerGenre(int customerId, List<String> genre) {
        this.customerId = customerId;
        this.genre = genre;
    }
}
