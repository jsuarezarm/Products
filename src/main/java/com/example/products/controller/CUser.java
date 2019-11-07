package com.example.products.controller;

import com.example.products.entity.User;
import com.example.products.model.MUser;
import com.example.products.service.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CUser {

    @Autowired
    @Qualifier("SUser")
    private SUser sUser;

    @PostMapping("/api/user")
    public boolean add(@RequestBody @Valid User user) {
        return sUser.create(user);
    }

    @DeleteMapping("/api/user/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return sUser.delete(id);
    }

    @GetMapping("/api/user")
    public List<MUser> getItems() {
        return sUser.getUsers();
    }

    @GetMapping("/user")
    public ModelAndView getItemListView() {
        ModelAndView view = new ModelAndView("user-list");
        view.addObject("users", getItems());
        return view;
    }

}
