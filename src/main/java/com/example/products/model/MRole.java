package com.example.products.model;

import com.example.products.entity.Role;

public class MRole {

    private int id;
    private String role;

    public MRole() {}

    public MRole(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public MRole(Role role) {
        this.id = role.getId();
        this.role = role.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
