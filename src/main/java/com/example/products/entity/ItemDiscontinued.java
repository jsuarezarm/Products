package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name="item_discontinued")
@Entity
public class ItemDiscontinued implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="item_id")
    private int itemId;

    @Column(name="user_id")
    private int userId;

    @Column(name="reason")
    private String reason;

    @Column(name="deactivation_date")
    private Date deactivationDate;

//    @OneToOne(targetEntity=Item.class, mappedBy="itemDiscontinued",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    private Item item = new Item();

    @ManyToOne()
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public ItemDiscontinued() {}

    public ItemDiscontinued(int id, int itemId, int userId, String reason, User user, Date deactivationDate) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.reason = reason;
        this.user = user;
        this.deactivationDate = deactivationDate;
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

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }
}
