package com.example.fooddeliveryapp.entities;

import java.io.Serializable;

public class Customer implements Serializable {
    //variables
    private String id, name, password, age;

    //constructors
    public Customer () {}

    public Customer (String _id, String _name, String _age, String _password) {
        this.id = _id;
        this.name = _name;
        this.age = _age;
        this.password = _password;

    }

    //getter setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge (String age) {
        this.age = age;
    }

}
