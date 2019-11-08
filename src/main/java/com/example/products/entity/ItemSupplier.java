package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="item_supplier")
@Entity
public class ItemSupplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="item_id")
    private int itemId;

    @Column(name="supplier_id")
    private int supplierId;

    public ItemSupplier() {}

    public ItemSupplier(int id, int itemId, int supplierId) {
        this.id = id;
        this.itemId = itemId;
        this.supplierId = supplierId;
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
