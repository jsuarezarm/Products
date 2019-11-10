package com.example.products.repository;

import com.example.products.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RSupplier")
public interface RSupplier extends JpaRepository<Supplier, Serializable> {

}