package com.example.products.service;

import com.example.products.entity.ItemSupplier;
import com.example.products.repository.RItemSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("SItemSupplier")
public class SItemSupplier {

    @Autowired
    @Qualifier("RItemSupplier")
    private RItemSupplier rItemSupplier;

    public boolean addSupplierToItem(ItemSupplier itemSupplier) {
        try {
            rItemSupplier.save(itemSupplier);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
