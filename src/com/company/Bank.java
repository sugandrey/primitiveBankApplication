package com.company;

import java.util.ArrayList;

public class Bank extends Branches {
    private String bankName;
    private ArrayList<Branches> branchesAndCustomersArrayList;
    private ArrayList<String> branchNames;

    public Bank(String bankName) {
        super(new ArrayList<>(), null);
        this.bankName = bankName;
        this.branchesAndCustomersArrayList = new ArrayList<>();
        this.branchNames = new ArrayList<>();
    }

    public ArrayList<Branches> getBranchesAndCustomersArrayList() {
        return branchesAndCustomersArrayList;
    }

    public ArrayList<String> getBranchNames() {
        return branchNames;
    }

    public void createBranchName(String nameOfBranch) {
        getBranchNames().add(nameOfBranch);
    }

    public void createNewCustomer(String nameOffice, String customerName, double firstPayment) {
        if (createNameAndAmount(customerName, firstPayment)) {
            Branches branches = new Branches(getCustomersArrayList(), nameOffice);
            getBranchesAndCustomersArrayList().add(branches);
            System.out.println("The new customer with name " + customerName +
                    " and first payment is " + firstPayment + " Dollars was created successfully");
        } else {
            System.out.println("Customer with name " + customerName + " already exist. Please add new customer");
        }
    }

    public void addAmountToCustomer(String customerName, double addAmount) {
        addAmount(customerName, addAmount);
    }

    public int findNameBranch(String nameBranch) {
        return this.getBranchNames().indexOf(nameBranch);
    }

    public void printBranches() {
        for (int i = 0; i < getBranchNames().size(); i++) {
            System.out.println((i+1) + ". -> " + getBranchNames().get(i));
        }
    }
}