package com.example.products.controller;

import com.example.products.entity.User;
import com.example.products.model.MUser;
import com.example.products.service.SRole;
import com.example.products.service.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CUser {

    @Autowired
    @Qualifier("SUser")
    private SUser sUser;

    @Autowired
    @Qualifier("SRole")
    private SRole sRole;

    @PostMapping("/api/user")
    public boolean add(@Valid User user) {
        return sUser.create(user);
    }

    @DeleteMapping("/api/user/{id}")
    public boolean delete(@PathVariable("id") int id) {
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
        view.addObject("roles", sRole.getRoles());
        return view;
    }

    @PostMapping("/user")
    public RedirectView addUser(User user) {
        sUser.create(user);
        return new RedirectView("/user");
    }

    @GetMapping("/user/{id}/delete")
    public RedirectView deleteItem(@PathVariable("id") int id) {
        sUser.delete(id);
        return new RedirectView("/user");
    }

}
