package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DealershipFileManager {


    public DealershipFileManager() {

    }

    public Dealership getDealership() {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("inventory.csv"))) {

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            String line1 = reader.readLine();
            String[] headerParts = line1.split("\\|");

            String name = headerParts[0];
            String address = headerParts[1];
            String phoneNumber = headerParts[2];

            String csvLine;

            while ((csvLine = reader.readLine()) != null) {

                String[] tokens = csvLine.split("\\|");

                if (tokens.length != 8) {
                    System.out.println("Skipping invalid transaction: " + csvLine);
                    continue;
                }

                try {
                    int vin = Integer.parseInt(tokens[0]);
                    int year = Integer.parseInt(tokens[1]);
                    String make = tokens[2];
                    String model = tokens[3];
                    String vehicleType = tokens[4];
                    String color = tokens[5];
                    int odometer = Integer.parseInt(tokens[6]);
                    BigDecimal price = new BigDecimal(tokens[7]);

                    Vehicle vehicle = new Vehicle(
                            vin, year, make, model, vehicleType, color, odometer, price
                    );
                    vehicles.add(vehicle);

                } catch (RuntimeException e) {
                    System.out.println("Skipping invalid transaction: " + csvLine);
                }
            }
            Dealership dealership = new Dealership(name, vehicles, phoneNumber, address);
            return dealership;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(Dealership dealership) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"))) {

            writer.write(dealership.getName() + "|"
                    + dealership.getAddress() + "|"
                    + dealership.getPhone());

            writer.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String csvLine = vehicle.getVin() + "|"
                        + vehicle.getYear() + "|"
                        + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|"
                        + vehicle.getVehicleType() + "|"
                        + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|"
                        + vehicle.getPrice();
                writer.write(csvLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving the dealership: " + e.getMessage());
        }
    }
}
