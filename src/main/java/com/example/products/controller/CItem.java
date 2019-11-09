package com.example.products.controller;

import com.example.products.entity.Item;
import com.example.products.model.MItem;
import com.example.products.service.SItem;
import com.example.products.service.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CItem {

    @Autowired
    @Qualifier("SItem")
    private SItem sItem;

    @Autowired
    @Qualifier("SUser")
    private SUser sUser;

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
    @GetMapping("/api/item/{id}")
    public MItem getItem(@PathVariable("id") int id) {
        return sItem.getItem(id);
    }

    // Edit item
    @PostMapping("/api/item/{code}/id")
    public boolean edit(@PathVariable("id") int id, @RequestBody @Valid Item editedItem) {
        return sItem.edit(id, editedItem);
    }

    @PostMapping("/api/item/{id}/deactivate")
    public boolean deactivate(@PathVariable("id") int id, @RequestBody @Valid String deactivationReason) {
        return sItem.deactivate(id, deactivationReason);
    }

    @DeleteMapping("/api/item/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return sItem.delete(id);
    }


    /**** View ****/

    @GetMapping("/item")
    public ModelAndView getItemListView() {
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", getItems());
        return view;
    }

    @GetMapping("/item/{id}")
    public ModelAndView getItemDetail(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("item-detail");
        view.addObject("product", getItem(id));
        return view;
    }

    @GetMapping("/item/{id}/edit")
    public ModelAndView editItem(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("item-edit");
        view.addObject("product", getItem(id));
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
