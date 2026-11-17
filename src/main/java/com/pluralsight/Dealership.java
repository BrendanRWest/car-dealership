package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, ArrayList<Vehicle> vehicles, String phone, String address) {
        this.name = name;
        this.inventory = vehicles;
        this.phone = phone;
        this.address = address;
    }

    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if((vehicle.getPrice().compareTo(min) > 0) && vehicle.getPrice().compareTo(max) < 0){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if(vehicle.getColor().equalsIgnoreCase(color)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }
}
