package com.example.products.repository;

import com.example.products.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RUsers")
public interface RUsers extends JpaRepository<Users, Serializable> {

    public abstract Users findByUsername(String username);

}
