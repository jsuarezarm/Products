package com.example.products.controller;

import com.example.products.entity.Item;
import com.example.products.entity.ItemDiscontinued;
import com.example.products.entity.ItemPricereduction;
import com.example.products.entity.ItemSupplier;
import com.example.products.model.MItem;
import com.example.products.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @Autowired
    @Qualifier("SSupplier")
    private SSupplier sSupplier;

    @Autowired
    @Qualifier("SPriceReduction")
    private SPriceReduction sPriceReduction;

    @Autowired
    @Qualifier("SItemSupplier")
    private SItemSupplier sItemSupplier;

    @Autowired
    @Qualifier("SItemPricereduction")
    private SItemPricereduction sItemPricereduction;

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

    @DeleteMapping("/api/item/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return sItem.delete(id);
    }


    /**** View ****/

    @GetMapping("/item")
    public ModelAndView getItemListView() {
        List<MItem> list =  getItems();
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", list);
        return view;
    }

    @GetMapping("/item/showact")
    public ModelAndView getItemListViewActive() {
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", sItem.getActiveItems());
        return view;
    }

    @GetMapping("/item/showdis")
    public ModelAndView getItemListViewDiscontinued() {
        ModelAndView view = new ModelAndView("item-list");
        view.addObject("products", sItem.getDiscontinuedItems());
        return view;
    }

    @GetMapping("/item/{id}")
    public ModelAndView getItemDetail(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("item-detail");
        view.addObject("product", getItem(id));
        return view;
    }

    @GetMapping("/item/{id}/deactivate")
    public ModelAndView getItemDeactivation(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("item-deactivation");
        view.addObject("product", getItem(id));
        return view;
    }

    @PostMapping("/item/{id}/deactivate")
    public RedirectView deactivate(@PathVariable("id") int id, ItemDiscontinued itemDiscontinued) {
        sItem.deactivate(id, itemDiscontinued.getReason());
        return new RedirectView("/item");
    }

    @GetMapping("/item/{id}/activate")
    public RedirectView activate(@PathVariable("id") int id) {
        sItem.activate(id);
        return new RedirectView("/item");
    }

    @GetMapping("/item/{id}/edit")
    public ModelAndView editItem(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("item-edit");
        view.addObject("product", getItem(id));
        view.addObject("suppliers", sSupplier.getSuppliers());
        view.addObject("pricereductions", sPriceReduction.getPriceReductions());
        return view;
    }

    @PostMapping("/item/{id}/edit")
    public RedirectView editItem(@PathVariable("id") int id, Item item) {
        sItem.edit(id, item);
        return new RedirectView("/item/" + id);
    }

    @PostMapping("/item")
    public RedirectView addItem(Item item) {
        sItem.create(item);
        return new RedirectView("/item");
    }

    @GetMapping("/item/{id}/delete")
    public RedirectView deleteItem(@PathVariable("id") int id) {
        sItem.delete(id);
        return new RedirectView("/item");
    }

    @PostMapping("/item/{id}/supplier")
    public RedirectView addSupplier(@PathVariable("id") int id, ItemSupplier itemSupplier) {
        ItemSupplier is = new ItemSupplier();
        is.setItemId(id);
        is.setSupplierId(itemSupplier.getSupplierId());
        sItemSupplier.addSupplierToItem(is);
        return new RedirectView("/item/" + id + "/edit");
    }

    @PostMapping("/item/{id}/pricereduction")
    public RedirectView addPriceReduction(@PathVariable("id") int id, ItemPricereduction itemPricereduction) {
        ItemPricereduction ipr = new ItemPricereduction();
        ipr.setItemId(id);
        ipr.setPricereductionId(itemPricereduction.getPricereductionId());
        sItemPricereduction.addPriceReductionToItem(ipr);
        return new RedirectView("/item/" + id + "/edit");
    }

}
