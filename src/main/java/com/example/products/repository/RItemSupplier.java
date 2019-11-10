package com.example.products.repository;

import com.example.products.entity.ItemSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RItemSupplier")
public interface RItemSupplier extends JpaRepository<ItemSupplier, Serializable> {

}