package com.example.products.converter;

import com.example.products.entity.Item;
import com.example.products.model.MItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class Converter {

    public List<MItem> convertList(List<Item> items) {
        List<MItem> mItems = new ArrayList<>();

        for(Item item : items) {
            mItems.add(new MItem(item));
        }

        return mItems;
    }

    public MItem convertItem(Item item) {
        return new MItem(item);
    }

}
