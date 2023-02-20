package com.example.iMelody.models;

import lombok.Data;

@Data
public class Invoice {
    private int customer_id;
    private int total;

    public Invoice(int customer_id, int total) {
        this.customer_id = customer_id;
        this.total = total;
    }
}
