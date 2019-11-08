package com.example.products.repository;

import com.example.products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RUser")
public interface RUser extends JpaRepository<User, Serializable> {

    public abstract User findById(int id);
    public abstract User findByUsername(String username);

}
