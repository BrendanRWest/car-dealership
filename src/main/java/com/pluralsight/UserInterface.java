package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public void UserInterface(){
    }

    private void init(){

        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display(){
        init();
        Scanner scan = new Scanner(System.in);
        String choice;
        boolean condition = true;

        while(condition){
            System.out.println("\nPlease select an option from the list below");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Your choice: ");
            choice = scan.nextLine();

            switch(choice){
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

    public void processGetByPriceRequest(Scanner scan){

        System.out.print("Please enter the minimum price you're searching for: ");
        BigDecimal min = scan.nextBigDecimal();
        scan.nextLine();

        System.out.print("Please enter the maximum price you're searching for: ");
        BigDecimal max = scan.nextBigDecimal();
        scan.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest(Scanner scan){

        System.out.print("Please enter the make you're searching for: ");
        String make = scan.nextLine();

        System.out.print("Please enter the model you're searching for: ");
        String model = scan.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest(Scanner scan){

        System.out.print("Please enter the earliest year: ");
        int minYear = scan.nextInt();
        scan.nextLine();

        System.out.print("Please enter the latest year: ");
        int maxYear = scan.nextInt();
        scan.nextLine();

        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void processGetByColorRequest(Scanner scan){

        System.out.print("Please enter the color you're searching for: ");
        String color = scan.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest(Scanner scan){

        System.out.print("Please enter the minimum miles: ");
        int minMiles = scan.nextInt();
        scan.nextLine();

        System.out.print("Please enter the maximum miles: ");
        int maxMiles = scan.nextInt();
        scan.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(minMiles, maxMiles));
    }

    public void processGetByVehicleTypeRequest(Scanner scan){

        System.out.print("Please enter the vehicle type for your search: ");
        String vehicleType = scan.nextLine();

        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    public void processGetAllVehiclesRequest(Scanner scan){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scan){

        System.out.print("Enter the vehicle vin name: ");
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

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);
        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest(Scanner scan){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        int vinChoice;

        System.out.println("Please enter the vin of the vehicle you'd like to remove: ");
        vinChoice = scan.nextInt();
        scan.nextLine();

        for (Vehicle vehicle : vehicles) {
            if(vehicle.getVin() == vinChoice){
                dealership.removeVehicle(vehicle);
                break;
            }
        }

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
    }

    private void displayVehicles(List<Vehicle> vehicles){

        for (Vehicle vehicle : vehicles) {
            System.out.println("\n" + vehicle);
        }
    }
}
