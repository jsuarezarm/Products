package com.example.products.repository;

import com.example.products.entity.ItemDiscontinued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RItemDiscontinued")
public interface RItemDiscontinued extends JpaRepository<ItemDiscontinued, Serializable> {

    public abstract ItemDiscontinued findById(int id);

}
