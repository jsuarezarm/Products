package com.example.products.model;

import com.example.products.entity.Users;

public class MUsers {

    private long id;
    private String username;
    private String password;

    public MUsers() {}

    public MUsers(Users users) {
        this.id = users.getId();
        this.username = users.getUsername();
        this.password = users.getPassword();
    }

    public MUsers(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
