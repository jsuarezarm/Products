package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.model.MPriceReduction;
import com.example.products.repository.RPriceReduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SPriceReduction")
public class SPriceReduction {

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    @Autowired
    @Qualifier("RPriceReduction")
    private RPriceReduction rPriceReduction;

    public List<MPriceReduction> getPriceReductions() {
        return converter.convertPriceReductionList(rPriceReduction.findAll());
    }

}