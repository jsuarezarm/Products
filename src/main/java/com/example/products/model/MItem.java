package com.example.products.model;

import com.example.products.entity.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

public class MItem {

    private int id;
    private int code;
    private String description;
    private BigDecimal price;
    private boolean state;
    private Date creationDate;
    private int creator;
    private Set<ItemDiscontinued> itemDiscontinued;
    private Set<Supplier> supplier;
    private Set<PriceReduction> pricereduction;
    private User user;

    public MItem(){}

    public MItem(int id, int code, String description, BigDecimal price, boolean state, Date creationDate, int creator,
                 Set<ItemDiscontinued> itemDiscontinued, Set<Supplier> supplier, Set<PriceReduction> pricereduction, User user) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
        this.state = state;
        this.creationDate = creationDate;
        this.creator = creator;
        this.itemDiscontinued = itemDiscontinued;
        this.supplier = supplier;
        this.pricereduction = pricereduction;
        this.user = user;
    }

    public MItem(Item item) {
        this.id = item.getId();
        this.code = item.getCode();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.state = item.getState();
        this.creationDate = item.getCreationDate();
        this.creator = item.getCreator();
        this.itemDiscontinued = item.getItemDiscontinued();
        this.supplier = item.getSuppliers();
        this.pricereduction = item.getPriceReduction();
        this.user = item.getUser();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Set<ItemDiscontinued> getItemDiscontinued() {
        return itemDiscontinued;
    }

    public void setItemDiscontinued(Set<ItemDiscontinued> itemDiscontinued) {
        this.itemDiscontinued = itemDiscontinued;
    }

    public Set<Supplier> getSuppliers() {
        return supplier;
    }

    public void setSuppliers(Set<Supplier> supplier) {
        this.supplier = supplier;
    }

    public Set<PriceReduction> getPriceReduction() {
        return pricereduction;
    }

    public void setPriceReduction(Set<PriceReduction> priceReduction) {
        this.pricereduction = priceReduction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
