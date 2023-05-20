package com.example.bookit;

import java.util.ArrayList;
import java.util.List;
public class Business {
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private String website;

    private String  type;

    public Business() {
        // Default constructor required for Firestore
    }

    public Business(String name, String description, String address, String phoneNumber, String website, String type) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.type = type;
    }

    // Getter and setter methods for the attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
