package com.pluralsight;

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

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }
}
