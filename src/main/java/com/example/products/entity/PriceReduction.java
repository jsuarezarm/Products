package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name="price_reduction")
@Entity
public class PriceReduction implements Serializable {

    @GeneratedValue
    @Id
    @Column(name="id")
    private long id;

    @Column(name="reduced_price")
    private double reducedPrice;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    public PriceReduction() {}

    public PriceReduction(long id, double reducedPrice, Date startDate, Date endDate) {
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
