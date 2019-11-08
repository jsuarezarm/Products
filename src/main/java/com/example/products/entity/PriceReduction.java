package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Table(name="price_reduction")
@Entity
public class PriceReduction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price_reduction")
    private BigDecimal priceReduction;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    public PriceReduction() {}

    public PriceReduction(int id, BigDecimal priceReduction, Date startDate, Date endDate) {
        this.id = id;
        this.priceReduction = priceReduction;
        this.startDate = startDate;
        this.endDate = endDate;
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
