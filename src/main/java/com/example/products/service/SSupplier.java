package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.model.MSupplier;
import com.example.products.repository.RSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SSupplier")
public class SSupplier {

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    @Autowired
    @Qualifier("RSupplier")
    private RSupplier rSupplier;

    public List<MSupplier> getSuppliers() {
        return converter.convertSuppliersList(rSupplier.findAll());
    }

}
