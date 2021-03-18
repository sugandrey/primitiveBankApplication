package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("North");

    public static void main(String[] args) {
        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("Enter your action");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 1:
                    printCustomersForBranch();
                    break;
                case 2:
                    addNewCustomerToBranch();
                    break;
                case 3:
                    addPayment();
                    break;
                case 4:
                    addBranch();
                    break;
                case 5:
                    System.out.println("\nExit from App...");
                    quit = true;
                    break;
                case 6:
                    branchPrint();
                    break;
            }
        }

    }

    private static void addNewCustomerToBranch() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        if (bank.findNameBranch(branchName) < 0) {
            bank.createBranchName(branchName);
        }
        System.out.println("Enter customer full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Enter first payment for customer " + fullName);
        while (true) {
            boolean isNextDouble = scanner.hasNextDouble();
            if (isNextDouble) {
                double firstPayment = scanner.nextDouble();
                bank.createNewCustomer(branchName, fullName, firstPayment);
                break;
            } else {
                System.out.println("Enter digits please.");
            }
            scanner.nextLine();
        }
    }

    private static void addBranch() {
        System.out.println("Enter new branch name: ");
        String branchName = scanner.nextLine();
        if (bank.findNameBranch(branchName) < 0) {
            bank.createBranchName(branchName);
            System.out.println("Branch with name " + branchName + " is created successfully");
        } else {
            System.out.println("Branch with name " + branchName + " already exists. Enter new Branch name. ");
        }
    }

    private static void addPayment() {
        System.out.println("Enter customer's name: ");
        String name = scanner.nextLine();
        if (bank.findName(name) >= 0) {
            System.out.println("Enter an additive payment for customer " + name);
            while (true) {
                boolean isNextDouble = scanner.hasNextDouble();
                if (isNextDouble) {
                    double payment = scanner.nextDouble();
                    bank.addAmountToCustomer(name, payment);
                    break;
                } else {
                    System.out.println("Enter digits please.");
                }
                scanner.nextLine();
            }

        } else {
            System.out.println("This customer don't exist. Add a new customer ");
        }
    }

    private static void printCustomersForBranch() {
        int count = 0;
        System.out.println("Enter branch name for customers list: ");
        String branchName = scanner.nextLine();
        if (bank.findNameBranch(branchName) < 0) {
            System.out.println("This branch doesn't exist.");
        }
        for (int i = 0; i < bank.getBranchesAndCustomersArrayList().size(); i++) {
            String name = bank.getBranchesAndCustomersArrayList().get(i).getNameBranch();
            if (name.equals(branchName)) {
                count++;
                System.out.println((count) + ". " + bank.getBranchesAndCustomersArrayList().get(i).getNameBranch() + " -> " +
                        bank.getBranchesAndCustomersArrayList().get(i).getCustomersArrayList().get(i).getCustomerName() +
                        " -> " + bank.getBranchesAndCustomersArrayList().get(i).getCustomersArrayList().get(i).getTransaction());
            }
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress");
        System.out.println("1 - to print branch customers list\n" +
                "2 - to add a new customer\n" +
                "3 - to add payment for a customer\n" +
                "4 - to add a new branch\n" +
                "5 - to go out from menu\n" +
                "6 - to print branches list\n");
    }

    private static void branchPrint() {
        System.out.println("List of branches: ");
        bank.printBranches();
    }
}

