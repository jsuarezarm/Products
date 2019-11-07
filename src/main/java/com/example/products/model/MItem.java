package com.example.products.model;

import com.example.products.entity.Item;

import java.sql.Date;

public class MItem {

    private long code;
    private String description;
    private double price;
    private boolean state;
    private Date creationDate;
    private long creator;

    public MItem(){}

    public MItem(Item item) {
        this.code = item.getCode();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.state = item.getState();
        this.creationDate = item.getCreationDate();
        this.creator = item.getCreator();
    }

    public MItem(long code, String description, double price, boolean state, Date creationDate, long creator) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.state = state;
        this.creationDate = creationDate;
        this.creator = creator;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }
}
