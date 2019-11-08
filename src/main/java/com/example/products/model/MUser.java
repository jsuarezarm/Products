package com.example.products.model;

import com.example.products.entity.Role;
import com.example.products.entity.User;

public class MUser {

    private int id;
    private String username;
    private String password;
    private int roleId;
    private Role role;

    public MUser() {}

    public MUser(int id, String username, String password, int roleId, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.role = role;
    }

    public MUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleId = user.getRoleId();
        this.role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
