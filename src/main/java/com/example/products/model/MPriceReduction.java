package com.example.products.model;

import com.example.products.entity.PriceReduction;

import java.sql.Date;

public class MPriceReduction {

    private long id;
    private double reducedPrice;
    private Date startDate;
    private Date endDate;

    public MPriceReduction() {}

    public MPriceReduction(PriceReduction priceReduction) {
        this.id = priceReduction.getId();
        this.reducedPrice = priceReduction.getReducedPrice();
        this.startDate = priceReduction.getStartDate();
        this.endDate = priceReduction.getEndDate();
    }

    public MPriceReduction(long id, double reducedPrice, Date startDate, Date endDate) {
        this.id = id;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
