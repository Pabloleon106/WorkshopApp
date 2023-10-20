package org.ulpgc.is1.model;

public class Item {
    private int quantity;
    private SparePart sparePart;

    public Item(SparePart sparePart, int quantity) {
        this.quantity = quantity;
        this.sparePart = sparePart;
    }
}

