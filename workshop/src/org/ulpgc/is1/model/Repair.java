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
}
