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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(String number) {
        this.plate = new Plate(number);
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public List<Repair> getRepairsList() {
        return repairsList;
    }

    public void setRepairsList(List<Repair> repairsList) {
        this.repairsList = repairsList;
    }
    public void addRepair(Repair repair) {
        repairsList.add(repair);
    }
    public void removeRepair(Repair repair) {
        repairsList.remove(repair);
    }

}
