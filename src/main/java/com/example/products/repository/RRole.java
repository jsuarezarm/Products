package com.example.products.repository;

import com.example.products.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RRole")
public interface RRole extends JpaRepository<Role, Serializable> {

    public abstract Role findById(int id);
    public abstract Role findByRole(String role);

}
