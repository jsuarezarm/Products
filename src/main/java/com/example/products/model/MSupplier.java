package com.example.products.model;

import com.example.products.entity.Supplier;

public class MSupplier {

    private long id;
    private String name;
    private String country;

    public MSupplier() {}

    public MSupplier(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.country = supplier.getCountry();
    }

    public MSupplier(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
