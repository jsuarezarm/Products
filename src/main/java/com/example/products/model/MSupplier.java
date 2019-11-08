package com.example.products.model;

import com.example.products.entity.Item;
import com.example.products.entity.Supplier;

import java.util.Set;

public class MSupplier {

    private int id;
    private String name;
    private String country;

    public MSupplier() {}

    public MSupplier(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public MSupplier(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.country = supplier.getCountry();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
