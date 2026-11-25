package com.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    // keeping the contracts in one shared file
    private static final String FILE_NAME = "contracts.csv";

    // saving the contract based on whether it was a sale or a lease
    public void saveContract(Contract contract) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            if (contract instanceof SalesContract) {

                SalesContract sales = (SalesContract) contract;

                writer.write("SALE|" +
                        contract.getDate() + "|" +
                        contract.getCustomerName() + "|" +
                        contract.getCustomerEmail() + "|" +
                        contract.getVehicle().getVin() + "|" +
                        contract.getVehicle().getYear() + "|" +
                        contract.getVehicle().getMake() + "|" +
                        contract.getVehicle().getModel() + "|" +
                        contract.getVehicle().getVehicleType() + "|" +
                        contract.getVehicle().getColor() + "|" +
                        contract.getVehicle().getOdometer() + "|" +
                        contract.getVehicle().getPrice() + "|" +
                        sales.getSalesTax() + "|" +
                        sales.getRecordingFee() + "|" +
                        sales.getProcessingFee() + "|" +
                        sales.getTotalPrice() + "|" +
                        sales.isFinanced() + "|" +
                        sales.getMonthlyPayment());

            } else if (contract instanceof LeaseContract) {

                LeaseContract lease = (LeaseContract) contract;

                writer.write("LEASE|" +
                        contract.getDate() + "|" +
                        contract.getCustomerName() + "|" +
                        contract.getCustomerEmail() + "|" +
                        contract.getVehicle().getVin() + "|" +
                        contract.getVehicle().getYear() + "|" +
                        contract.getVehicle().getMake() + "|" +
                        contract.getVehicle().getModel() + "|" +
                        contract.getVehicle().getVehicleType() + "|" +
                        contract.getVehicle().getColor() + "|" +
                        contract.getVehicle().getOdometer() + "|" +
                        contract.getVehicle().getPrice() + "|" +
                        lease.getExpectedEndingValue() + "|" +
                        lease.getLeaseFee() + "|" +
                        lease.getTotalPrice() + "|" +
                        lease.getMonthlyPayment());
            }

            writer.newLine();

            System.out.println("your contract was saved successfully!");

        } catch (IOException e) {
            System.out.println("there was an issue saving your contract.");
            e.printStackTrace();
        }
    }
}
