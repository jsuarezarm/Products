package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="supplier")
@Entity
public class Supplier implements Serializable {

    @GeneratedValue
    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    public Supplier() {}

    public Supplier(long id, String name, String country) {
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
