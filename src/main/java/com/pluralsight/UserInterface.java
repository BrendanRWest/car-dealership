package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    private void init() {

        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayWelcomeScreen() {
        System.out.println("==========================================");
        System.out.println("            D & B Used Cars");
        System.out.println("==========================================");

        System.out.println("           ______");
        System.out.println("      ____/|_||_\\`.__");
        System.out.println("     (   _        _ _\\");
        System.out.println("     =`-(_)--(_)-'");

        System.out.println("\nWelcome to the Dealership Management System!");
        System.out.print("\nLoading inventory [");

        for (int i = 0; i < 20; i++) {
            System.out.print("#");
        }

        System.out.println("] 100%");
        System.out.println("Inventory loaded successfully.");
    }

    public void display() {
        init();
        displayWelcomeScreen();

        Scanner scan = new Scanner(System.in);
        String choice;
        boolean condition = true;

        while (condition) {
            System.out.println("\n==========================================");
            System.out.println("         D & B Used Cars - MENU");
            System.out.println("==========================================");
            System.out.println("1  - Search Inventory by Price");
            System.out.println("2  - Search Inventory by Make / Model");
            System.out.println("3  - Search Inventory by Year");
            System.out.println("4  - Search Inventory by Color");
            System.out.println("5  - Search Inventory by Mileage");
            System.out.println("6  - Search Inventory by Vehicle Type");
            System.out.println("7  - View Entire Inventory");
            System.out.println("8  - Add Vehicle to Inventory");
            System.out.println("9  - Remove Vehicle from Inventory");
            System.out.println("99 - Close Dealership System");
            System.out.println("------------------------------------------");
            System.out.print("Your Choice: ");
            choice = scan.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest(scan);
                    break;
                case "2":
                    processGetByMakeModelRequest(scan);
                    break;
                case "3":
                    processGetByYearRequest(scan);
                    break;
                case "4":
                    processGetByColorRequest(scan);
                    break;
                case "5":
                    processGetByMileageRequest(scan);
                    break;
                case "6":
                    processGetByVehicleTypeRequest(scan);
                    break;
                case "7":
                    processGetAllVehiclesRequest(scan);
                    break;
                case "8":
                    processAddVehicleRequest(scan);
                    break;
                case "9":
                    processRemoveVehicleRequest(scan);
                    break;
                case "99":
                    condition = false;
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
        scan.close();
    }

    public void processGetByPriceRequest(Scanner scan) {
        try {
            System.out.print("Please enter the minimum price: ");
            BigDecimal min = scan.nextBigDecimal();
            scan.nextLine();

            System.out.print("Please enter the maximum price: ");
            BigDecimal max = scan.nextBigDecimal();
            scan.nextLine();

            displayVehicles(dealership.getVehiclesByPrice(min, max));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! You must enter numbers for the prices.");
            scan.nextLine();
        }
    }

    public void processGetByMakeModelRequest(Scanner scan) {

        System.out.print("Please enter the make you're searching for: ");
        String make = scan.nextLine();

        System.out.print("Please enter the model you're searching for: ");
        String model = scan.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest(Scanner scan) {
        try {
            System.out.print("Please enter the earliest year: ");
            int minYear = scan.nextInt();
            scan.nextLine();

            System.out.print("Please enter the latest year: ");
            int maxYear = scan.nextInt();
            scan.nextLine();

            displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! You must enter a number for the year.");
            scan.nextLine();
        }
    }

    public void processGetByColorRequest(Scanner scan) {

        System.out.print("Please enter the color you're searching for: ");
        String color = scan.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest(Scanner scan) {
        try {
            System.out.print("Please enter the minimum mileage: ");
            int min = scan.nextInt();
            scan.nextLine();

            System.out.print("Please enter the maximum mileage: ");
            int max = scan.nextInt();
            scan.nextLine();

            displayVehicles(dealership.getVehiclesByYear(min, max));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! You must enter numbers for the mileages.");
            scan.nextLine();
        }
    }

    public void processGetByVehicleTypeRequest(Scanner scan) {

        System.out.print("Please enter the vehicle type for your search: ");
        String vehicleType = scan.nextLine();

        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    public void processGetAllVehiclesRequest(Scanner scan) {

        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scan) {

        try {
            System.out.print("Enter the vehicle vin: ");
            int vin = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter the vehicle year: ");
            int year = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter the vehicle make: ");
            String make = scan.nextLine();

            System.out.print("Enter the vehicle model: ");
            String model = scan.nextLine();

            System.out.print("Enter the vehicle type: ");
            String vehicleType = scan.nextLine();

            System.out.print("Enter the vehicle color: ");
            String color = scan.nextLine();

            System.out.print("Enter the number of miles on the vehicle odometer: ");
            int mileage = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter the price of the vehicle: ");
            BigDecimal price = scan.nextBigDecimal();
            scan.nextLine();

            Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);
            dealership.addVehicle(vehicle);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Could not add vehicle!");
            scan.nextLine();
        }

    }

    public void processRemoveVehicleRequest(Scanner scan) {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        System.out.println("Please enter the vin of the vehicle you'd like to remove: ");
        int vinChoice;

        while (true) {
            System.out.print("Enter vehicle VIN: ");

            try {
                vinChoice = Integer.parseInt(scan.nextLine());

                if (vinChoice > 0) {
                    break;
                }

                System.out.println("VIN must be positive.");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vinChoice) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle successfully removed!");
                break;
            }
        }

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
    }

    private void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles found.");
            return;
        }

        System.out.println("\n==================== INVENTORY ====================");

        System.out.printf("%-8s %-6s %-12s %-14s %-8s %12s%n",
                "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "PRICE");

        System.out.println("---------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-8d %-6d %-12s %-14s %-8s $%,11.2f%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getPrice());
        }
    }
}
