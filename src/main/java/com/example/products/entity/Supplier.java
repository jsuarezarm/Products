package com.example.products.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name="supplier")
@Entity
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

////    @ManyToMany(targetEntity=Item.class, mappedBy="supplier",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    @ManyToMany(mappedBy = "supplier")
//    @JsonManagedReference
//    private Set<Item> item;

    public Supplier() {}

    public Supplier(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
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
