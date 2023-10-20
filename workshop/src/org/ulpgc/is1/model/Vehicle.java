package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String make;
    private String model;
    private Plate plate;
    private Customer owner;
    private List<Repair> repairsList;

    public Vehicle(String make, String model, Plate plate, Customer owner) {
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.owner = owner;
        repairsList = new ArrayList<>();
    }
}
