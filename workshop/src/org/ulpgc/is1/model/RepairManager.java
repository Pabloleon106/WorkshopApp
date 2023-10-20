package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class RepairManager {
    private final List<Mechanic> mechanicList;
    private final List<Vehicle> vehicleList;
    private final List<Repair> repairsList;
    private final List<SparePart> stockList;

    public RepairManager() {
        mechanicList = new ArrayList<>();
        vehicleList = new ArrayList<>();
        repairsList = new ArrayList<>();
        stockList = new ArrayList<>();
    }

    public Mechanic getMechanic(String name) {
        for (Mechanic mechanic : mechanicList) {
            if (mechanic.getName().equals(name)) {
                return mechanic;
            }
        }
        return null;
    }

    public Vehicle getVehicle(String plate) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getPlate().getNumber().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Repair> getRepairsList() {
        return repairsList;
    }

    public List<SparePart> getStockList() {
        return stockList;
    }


}
