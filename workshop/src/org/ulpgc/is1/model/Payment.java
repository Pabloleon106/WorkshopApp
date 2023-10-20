package org.ulpgc.is1.model;

import java.util.Date;

public class Payment {
    private Date date;
    private int amount;

    public Payment(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}
