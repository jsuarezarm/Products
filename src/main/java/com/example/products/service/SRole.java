package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.model.MRole;
import com.example.products.repository.RRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SRole")
public class SRole {

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    @Autowired
    @Qualifier("RRole")
    private RRole rRole;

    public List<MRole> getRoles() {
        return converter.convertRolesList(rRole.findAll());
    }

}
