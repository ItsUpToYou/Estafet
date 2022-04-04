package com.estafet.exception;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersBuilder {
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String email;
    private int itemQuantity;
    private int totalPrice;


    public OrdersBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public OrdersBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public OrdersBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public OrdersBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public OrdersBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public OrdersBuilder setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
        return this;
    }

    public OrdersBuilder setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Orders build() {
        return new Orders(firstName, lastName, city, address, email, itemQuantity, totalPrice);
    }
}