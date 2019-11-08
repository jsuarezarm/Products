package com.example.products.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="users")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role_id")
    private int roleId;

    @ManyToOne()
    @JoinColumn(name="id", insertable = false, updatable = false)
    private Role role;

    @OneToOne(targetEntity=ItemDiscontinued.class, mappedBy="user",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private ItemDiscontinued itemDiscontinued = new ItemDiscontinued();

    public User() {}

    public User(int id, String username, String password, int roleId, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.role = role;
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
