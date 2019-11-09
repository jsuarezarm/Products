package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.entity.Item;
import com.example.products.entity.ItemDiscontinued;
import com.example.products.entity.User;
import com.example.products.model.MItem;
import com.example.products.repository.RItem;
import com.example.products.repository.RItemDiscontinued;
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

    @Autowired
    @Qualifier("RItemDiscontinued")
    private RItemDiscontinued rItemDiscontinued;

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

    public MItem getItem(int id) {
        Item i = rItem.findById(id);

        return converter.convertItem(i);
    }

    public boolean edit(int id, Item editedItem) {
        try {
            // Get item unmodified
            Item item = rItem.findById(id);

            // Don't allow to change the item code
            editedItem.setCode(item.getCode());

            rItem.save(editedItem);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean deactivate(int id, String deactivationReason) {
        try {
            Item item = rItem.findById(id);
            item.setState(false);
            rItem.save(item);

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
            }

            ItemDiscontinued itemDiscontinued = new ItemDiscontinued();
            itemDiscontinued.setItemId(id);
            itemDiscontinued.setReason(deactivationReason);
            itemDiscontinued.setUserId(rUser.findByUsername(username).getId());
            itemDiscontinued.setDeactivationDate(new Date(Calendar.getInstance().getTime().getTime()));
            rItemDiscontinued.save(itemDiscontinued);

            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean activate(int id) {
        try {
            Item item = rItem.findById(id);
            item.setState(true);
            rItem.save(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            Item item = rItem.findById(id);
            rItem.delete(item);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
