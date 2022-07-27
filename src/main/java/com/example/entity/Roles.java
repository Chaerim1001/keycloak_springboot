package com.example.entity;

import javax.persistence.*;

@Table(name="roles")
@Entity
public class Roles {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "role")
    private String role;

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return this.id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}