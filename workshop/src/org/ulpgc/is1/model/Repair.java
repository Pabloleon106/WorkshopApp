package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair {
    private int NEXT_ID = 1;
    private int id;
    private Date date;
    private String description;
    private int effort;
    private List<Item> items;
    private BreakdownTypes breakdownType;
    private Vehicle vehicle;
    private Payment payment;


    public Repair(Date date, String description, int effort) {
        this.id = NEXT_ID + 1;
        this.date = date;
        this.description = description;
        this.effort = effort;
        items = new ArrayList<>();
    }

    public int price() {
        int total = 0;
        for (Item item : items) {
            total = total + item.getQuantity() * item.getSparePart().getPrice();
        }
        return total;
    }


    public int getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }


    public int getEffort() {
        return effort;
    }

    public List<Item> getItems() {
        return items;
    }

    public BreakdownTypes getBreakdownType() {
        return breakdownType;
    }

    public void setBreakdownType(BreakdownTypes breakdownType) {
        this.breakdownType = breakdownType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void addPart(SparePart sparePart, int quantity) {
        Item item = new Item(sparePart, quantity);
        items.add(item);
    }
}
