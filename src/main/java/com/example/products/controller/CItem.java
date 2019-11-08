package com.example.products.controller;

import com.example.products.entity.Item;
import com.example.products.model.MItem;
import com.example.products.service.SItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    public boolean add(@Valid @RequestBody Item item) {
        return sItem.create(item);
    }

    // List all items
    @GetMapping("/api/item")
    public List<MItem> getItems() {
        return sItem.getItems();
    }

    // List item by code
    @GetMapping("/api/item/{code}")
    public MItem getItem(@PathVariable("code") int code) {
        return sItem.getItem(code);
    }

    // Edit item
    @PostMapping("/api/item/{code}/edit")
    public boolean edit(@PathVariable("code") int code, @RequestBody @Valid Item editedItem) {
        return sItem.edit(code, editedItem);
    }

    @PostMapping("/api/item/{code}/deactivate")
    public boolean deactivate(@PathVariable("code") int code, @RequestBody @Valid String deactivationReason) {
        return sItem.deactivate(code, deactivationReason);
    }

    @DeleteMapping("/api/item/{code}")
    public boolean delete(@PathVariable("code") int code) {
        return sItem.delete(code);
    }


    /**** View ****/

    @GetMapping("/item")
    public ModelAndView getItemListView() {
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", getItems());
        return view;
    }

    @PostMapping("/item")
    public ModelAndView addItem(Item item) {
        sItem.create(item);
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", getItems());
        return view;
    }

    @GetMapping("/item/{code}/delete")
    public ModelAndView deleteItem(@PathVariable("code") int code) {
        sItem.delete(code);
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", getItems());
        return view;
    }

}
