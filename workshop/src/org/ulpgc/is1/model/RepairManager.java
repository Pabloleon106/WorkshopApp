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
}
