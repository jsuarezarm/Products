package com.example.products.converter;

import com.example.products.entity.*;
import com.example.products.model.*;
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

    public List<MSupplier> convertSuppliersList(List<Supplier> suppliers) {
        List<MSupplier> mSuppliers = new ArrayList<>();

        for(Supplier supplier : suppliers) {
            mSuppliers.add(new MSupplier(supplier));
        }

        return mSuppliers;
    }

    public List<MPriceReduction> convertPriceReductionList(List<PriceReduction> priceReductions) {
        List<MPriceReduction> mPriceReductions = new ArrayList<>();

        for(PriceReduction priceReduction : priceReductions) {
            mPriceReductions.add(new MPriceReduction(priceReduction));
        }

        return mPriceReductions;
    }

    public List<MRole> convertRolesList(List<Role> roles) {
        List<MRole> mRoles = new ArrayList<>();

        for(Role role : roles) {
            mRoles.add(new MRole(role));
        }

        return mRoles;
    }

}
