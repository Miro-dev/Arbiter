package com.miros.entities;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "ardeos_corporation")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user;
    private String name;
    private String password;
    private String roles;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
