package com.company;

import java.util.ArrayList;

public class Branches {

    private double amount;
    private ArrayList<Customers> customersArrayList;
    private String nameBranch;
    public Branches(ArrayList<Customers> customersArrayList, String nameBranch) {
        this.amount = 0;
        this.customersArrayList = customersArrayList;
        this.nameBranch = nameBranch;

    }

    public double getAmount() {
        return amount;
    }

    public ArrayList<Customers> getCustomersArrayList() {
        return customersArrayList;
    }


    public String getNameBranch() {
        return nameBranch;
    }

    private boolean addNameAndAmount(String name, double firstPayment) {
        if (findName(name) < 0) {
            ArrayList<Double> existCustomer = new ArrayList<>();
            Customers customers = Customers.createCustomer(name,existCustomer);
            this.customersArrayList.add(customers);
            customers.getTransaction().add(firstPayment);
            return true;
        }
            else {return false;}
    }

    public boolean addAmount(String existName, double addPayment) {
        if (findName(existName) >= 0) {
            Customers customers = this.customersArrayList.get(findName(existName));
            customers.getTransaction().add(addPayment);
            System.out.println("Amount is " + addPayment + " Dollars added successfully for customer " + customers.getCustomerName());
            System.out.println(customers.getCustomerName() + " -> " + customers.getTransaction());
            return true;
        }
        System.out.println("Customer with name " + existName + " doesn't exist. Please add this customer");
        return false;
    }

    public int findName(String name) {
        for (int i = 0; i < this.customersArrayList.size(); i++) {
            Customers customers = this.customersArrayList.get(i);
            if (customers.getCustomerName().equals(name)) {
                return i;
            }

        } return -1;
    }

    private double balance(String name) {
        double total = 0;
        if (findName(name) >= 0) {
            Customers customers = this.customersArrayList.get(findName(name));
            for (int i = 0; i < customers.getTransaction().size(); i++) {
                total += customers.getTransaction().get(i);
            }
            this.amount = total;
            System.out.println("Total Amount Customer with name " + name + " is " + getAmount() + " Dollars.");
            return this.amount;
        } else {
            System.out.println("Such a customer not found");
            return -1;
        }
    }
    public boolean createNameAndAmount(String name, double sum) {
        if (addNameAndAmount(name, sum)) {
            return true;
        }
        else {
            return false;
        }
    }
}

