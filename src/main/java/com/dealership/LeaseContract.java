package com.dealership;

import java.time.LocalDate;

public class LeaseContract extends Contract {

    // keeping track of the lease costs
    private double expectedEndingValue;
    private double leaseFee;

    // lease financing stays at 4% for 36 months
    private static final double INTEREST_RATE = 0.04;
    private static final int LEASE_MONTHS = 36;

    // setting up the lease with the customer's information
    public LeaseContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle) {

        super(date, customerName, customerEmail, vehicle);

        // figuring out the expected value at the end of the lease
        this.expectedEndingValue = vehicle.getPrice() * 0.50;

        // adding the lease fee
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    // getting the expected ending value
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    // getting the lease fee
    public double getLeaseFee() {
        return leaseFee;
    }

    // calculating the full lease price
    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }

    // calculating the monthly lease payment
    @Override
    public double getMonthlyPayment() {

        double principal = getTotalPrice();

        double monthlyRate = INTEREST_RATE / 12;

        double payment = principal * monthlyRate /
                (1 - Math.pow(1 + monthlyRate, -LEASE_MONTHS));

        return payment;
    }
}