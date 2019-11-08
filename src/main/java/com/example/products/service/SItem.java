package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.entity.Item;
import com.example.products.entity.User;
import com.example.products.model.MItem;
import com.example.products.repository.RItem;
import com.example.products.repository.RUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service("SItem")
public class SItem {

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    @Autowired
    @Qualifier("RItem")
    private RItem rItem;

    @Autowired
    @Qualifier("RUser")
    private RUser rUser;

    public boolean create(Item item) {
        try {
            // Set creation date
            item.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));

            // Set Active state
            item.setState(true);

            // Set creator
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
            }
            User user = rUser.findByUsername(username);
            item.setCreator(user.getId());

            rItem.save(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<MItem> getItems() {
        return converter.convertItemList(rItem.findAll());
    }

    public MItem getItem(int code) {
        return converter.convertItem(rItem.findByCode(code));
    }

    public boolean edit(int code, Item editedItem) {
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

    public boolean deactivate(int code, String deactivationReason) {
        try {
            Item item = rItem.findByCode(code);
            item.setState(false);
            rItem.save(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(int code) {
        try {
            Item item = rItem.findByCode(code);
            rItem.delete(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
