package com.pluralsight;

import java.math.BigDecimal;
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
            System.out.println("Please select an option from the list below");
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

    }

    public void processGetByYearRequest(Scanner scan){

    }

    public void processGetByColorRequest(Scanner scan){

    }

    public void processGetByMileageRequest(Scanner scan){

    }

    public void processGetByVehicleTypeRequest(Scanner scan){

    }

    public void processGetAllVehiclesRequest(Scanner scan){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scan){

    }

    public void processRemoveVehicleRequest(Scanner scan){

    }

    private void displayVehicles(List<Vehicle> vehicles){

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle + "\n");
        }
    }
}
