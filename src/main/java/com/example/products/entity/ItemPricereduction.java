package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="item_pricereduction")
@Entity
public class ItemPricereduction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="item_id")
    private int itemId;

    @Column(name="pricereduction_id")
    private int pricereductionId;

    public ItemPricereduction() {}

    public ItemPricereduction(int id, int itemId, int pricereductionId) {
        this.id = id;
        this.itemId = itemId;
        this.pricereductionId = pricereductionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPricereductionId() {
        return pricereductionId;
    }

    public void setPricereductionId(int pricereductionId) {
        this.pricereductionId = pricereductionId;
    }
}
