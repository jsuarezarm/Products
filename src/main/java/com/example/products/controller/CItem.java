package com.example.products.controller;

import com.example.products.entity.Item;
import com.example.products.model.MItem;
import com.example.products.service.SItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class CItem {

    @Autowired
    @Qualifier("SItem")
    private SItem sItem;

    // Add item
    @PostMapping("/api/item")
    public boolean add(@RequestBody @Valid Item item) {
        return sItem.create(item);
    }

    // List all items
    @GetMapping("/api/item")
    public List<MItem> getItems() {
        return sItem.getItems();
    }

    // List item by code
    @GetMapping("/api/item/{code}")
    public MItem getItem(@PathVariable("code") long code) {
        return sItem.getItem(code);
    }

    // Edit item
    @PostMapping("/api/item/{code}/edit")
    public boolean edit(@PathVariable("code") long code, @RequestBody @Valid Item editedItem) {
        return sItem.edit(code, editedItem);
    }

    @PostMapping("/api/item/{code}/deactivate")
    public boolean deactivate(@PathVariable("code") long code, @RequestBody @Valid String deactivationReason) {
        return sItem.deactivate(code, deactivationReason);
    }

    @DeleteMapping("/api/item/{code}")
    public boolean delete(@PathVariable("code") long code) {
        return sItem.delete(code);
    }


    /**** View ****/

    @GetMapping("/item")
    public ModelAndView getItemListView() {
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", getItems());
        return view;
    }

}
