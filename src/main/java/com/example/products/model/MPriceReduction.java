package com.example.products.model;

import com.example.products.entity.PriceReduction;

import java.math.BigDecimal;
import java.sql.Date;

public class MPriceReduction {

    private int id;
    private BigDecimal priceReduction;
    private Date startDate;
    private Date endDate;

    public MPriceReduction() {}

    public MPriceReduction(int id, BigDecimal priceReduction, Date startDate, Date endDate) {
        this.id = id;
        this.priceReduction = priceReduction;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MPriceReduction(PriceReduction priceReduction) {
        this.id = priceReduction.getId();
        this.priceReduction = priceReduction.getPriceReduction();
        this.startDate = priceReduction.getStartDate();
        this.endDate = priceReduction.getEndDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(BigDecimal priceReduction) {
        this.priceReduction = priceReduction;
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
