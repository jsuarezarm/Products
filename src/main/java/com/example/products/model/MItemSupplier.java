package com.example.products.model;

import com.example.products.entity.ItemSupplier;

public class MItemSupplier {

    private int id;
    private int itemId;
    private int supplierId;

    public MItemSupplier() {}

    public MItemSupplier(int id, int itemId, int supplierId) {
        this.id = id;
        this.itemId = itemId;
        this.supplierId = supplierId;
    }

    public MItemSupplier(ItemSupplier itemSupplier) {
        this.id = itemSupplier.getId();
        this.itemId = itemSupplier.getItemId();
        this.supplierId = itemSupplier.getSupplierId();
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

}
