package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.entity.Item;
import com.example.products.model.MItem;
import com.example.products.repository.RItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SItem")
public class SItem {

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    @Autowired
    @Qualifier("RItem")
    private RItem rItem;

    public boolean create(Item item) {
        try {
            rItem.save(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<MItem> getItems() {
        return converter.convertItemList(rItem.findAll());
    }

    public MItem getItem(long code) {
        return converter.convertItem(rItem.findByCode(code));
    }

    public boolean edit(long code, Item editedItem) {
        try {
            // Get item unmodified
            Item item = rItem.findByCode(code);

            // Don't allow to change the item code
            editedItem.setCode(item.getCode());

            rItem.save(editedItem);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean deactivate(long code, String deactivationReason) {
        try {
            Item item = rItem.findByCode(code);
            item.setState(false);
            rItem.save(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(long code) {
        try {
            Item item = rItem.findByCode(code);
            rItem.delete(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
