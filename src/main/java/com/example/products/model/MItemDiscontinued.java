package com.example.products.model;

import com.example.products.entity.ItemDiscontinued;
import com.example.products.entity.User;

public class MItemDiscontinued {

    private int id;
    private int itemId;
    private int userId;
    private String reason;
    private User user;

    public MItemDiscontinued() {}

    public MItemDiscontinued(int id, int itemId, int userId, String reason, User user) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.reason = reason;
        this.user = user;
    }

    public MItemDiscontinued(ItemDiscontinued itemDiscontinued) {
        this.id = itemDiscontinued.getId();
        this.itemId = itemDiscontinued.getItemId();
        this.userId = itemDiscontinued.getUserId();
        this.reason = itemDiscontinued.getReason();
        this.user = itemDiscontinued.getUser();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
