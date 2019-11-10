package com.example.products.repository;

import com.example.products.entity.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RPriceReduction")
public interface RPriceReduction extends JpaRepository<PriceReduction, Serializable> {

}