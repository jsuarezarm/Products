package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="users")
@Entity
public class Users implements Serializable {

    @GeneratedValue
    @Id
    @Column(name="id")
    private long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public Users() {}

    public Users(long id, String username, String password) {
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
