package com.example.products.repository;

import com.example.products.entity.ItemPricereduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RItemPricereduction")
public interface RItemPricereduction extends JpaRepository<ItemPricereduction, Serializable> {

}
