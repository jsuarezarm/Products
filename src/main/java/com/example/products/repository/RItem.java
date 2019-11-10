package com.example.products.repository;

import com.example.products.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("RItem")
public interface RItem extends JpaRepository<Item, Serializable> {

    public abstract Item findById(int id);
    public abstract List<Item> findByState(boolean state);
    public abstract List<Item> findByCreator(int creatorId);

}
