package com.example.products.model;

import com.example.products.entity.Item;

public class MItem {

    private long code;
    private String description;
    private double price;
    private boolean state;

    public MItem(){}

    public MItem(Item item) {
        this.code = item.getCode();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.state = item.getState();
    }

    public MItem(long code, String description, double price, boolean state) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.state = state;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }



}
