package com.dealership;

import java.time.LocalDate;

public abstract class Contract {

    // keeping the information that both sales and lease contracts will need
    private LocalDate date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;

    // setting up the basic contract information
    public Contract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    // getting the contract date
    public LocalDate getDate() {
        return date;
    }

    // getting the customer's name
    public String getCustomerName() {
        return customerName;
    }

    // getting the customer's email
    public String getCustomerEmail() {
        return customerEmail;
    }

    // getting the vehicle attached to this contract
    public Vehicle getVehicle() {
        return vehicle;
    }

    // each type of contract will calculate the total price differently
    public abstract double getTotalPrice();

    // this will also depend on whether its a sale or a lease
    public abstract double getMonthlyPayment();
}
