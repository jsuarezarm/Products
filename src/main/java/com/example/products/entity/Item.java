package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name="item")
@Entity
public class Item implements Serializable {

    @GeneratedValue
    @Id
    @Column(name="code")
    private long code;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="state")
    private boolean state;

    // Suppliers

    // Price reductions

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="creator")
    private long creator;

    public Item(){}

    public Item(long code, String description, double price, boolean state) {
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
