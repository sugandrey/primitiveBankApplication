package com.company;

import java.util.ArrayList;

public class Customers {
    private String customerName;
    private ArrayList<Double> transaction;

    public Customers(String customerName, ArrayList<Double> transaction) {
        this.customerName = customerName;
        this.transaction = transaction;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public static Customers createCustomer(String customerName, ArrayList<Double> transaction) {
        return new Customers(customerName, transaction);
    }

}
