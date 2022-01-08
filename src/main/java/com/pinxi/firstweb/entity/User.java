package com.pinxi.firstweb.entity;

public class User {
    //properties
    private int id;
    private String name;
    private String password;

    //getter
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    //constructor
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
