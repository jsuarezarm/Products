package com.example.products.model;

import com.example.products.entity.ItemPricereduction;

public class MItemPricereduction {

    private int id;
    private int itemId;
    private int pricereductionId;

    public MItemPricereduction() {}

    public MItemPricereduction(int id, int itemId, int pricereductionId) {
        this.id = id;
        this.itemId = itemId;
        this.pricereductionId = pricereductionId;
    }

    public MItemPricereduction(ItemPricereduction itemPricereduction) {
        this.id = itemPricereduction.getId();
        this.itemId = itemPricereduction.getItemId();
        this.pricereductionId = itemPricereduction.getPricereductionId();
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
