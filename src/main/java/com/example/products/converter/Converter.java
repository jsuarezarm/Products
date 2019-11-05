package com.example.products.converter;

import com.example.products.entity.Item;
import com.example.products.entity.User;
import com.example.products.model.MItem;
import com.example.products.model.MUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class Converter {

    public List<MItem> convertItemList(List<Item> items) {
        List<MItem> mItems = new ArrayList<>();

        for(Item item : items) {
            mItems.add(new MItem(item));
        }

        return mItems;
    }

    public MItem convertItem(Item item) {
        return new MItem(item);
    }

    public List<MUser> convertUsersList(List<User> users) {
        List<MUser> mUsers = new ArrayList<>();

        for(User user : users) {
            mUsers.add(new MUser(user));
        }

        return mUsers;
    }

}
