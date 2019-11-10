package com.example.products.controller;

import com.example.products.entity.User;
import com.example.products.model.MUser;
import com.example.products.service.SRole;
import com.example.products.service.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CWeb {

    @Autowired
    @Qualifier("SUser")
    private SUser sUser;

    @Autowired
    @Qualifier("SRole")
    private SRole sRole;

    @GetMapping("/")
    public ModelAndView checkIfThereIsAnAdmin() {
        ModelAndView view;
        List<MUser> admins = sUser.getAdmins();

        if(admins.isEmpty()) {
            view = new ModelAndView("admin-create");
        } else {
            view = new ModelAndView("home");
        }

        return view;
    }

    @PostMapping("createadmin")
    public RedirectView createAdmin(User user) {
        if(sUser.getAdmins().isEmpty()) {
            sUser.createAdmin(user);
        }
        return new RedirectView("/");
    }

}
