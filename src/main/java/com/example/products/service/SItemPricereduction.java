package com.example.products.service;

import com.example.products.entity.ItemPricereduction;
import com.example.products.repository.RItemPricereduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("SItemPricereduction")
public class SItemPricereduction {

    @Autowired
    @Qualifier("RItemPricereduction")
    private RItemPricereduction rItemPricereduction;

    public boolean addPriceReductionToItem(ItemPricereduction itemPricereduction) {
        try {
            rItemPricereduction.save(itemPricereduction);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
