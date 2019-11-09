package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Table(name="item")
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private int code;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="state")
    private boolean state;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="creator")
    private int creator;

    @OneToMany
    @OrderBy("deactivation_date desc")
    @JoinColumn(name="item_id")
    private Set<ItemDiscontinued> itemDiscontinued;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="item_supplier", joinColumns = {@JoinColumn(referencedColumnName ="id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Supplier> supplier;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="item_pricereduction", joinColumns = {@JoinColumn(referencedColumnName ="id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<PriceReduction> pricereduction;

    @ManyToOne
    @JoinColumn(name="creator", insertable = false, updatable = false)
    private User user;

    public Item(){}

    public Item(int id, int code, String description, BigDecimal price, boolean state, Date creationDate, int creator,
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

    public void setPriceReduction(Set<PriceReduction> pricereduction) {
        this.pricereduction = pricereduction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
