package com.example.bookit;

public class Service {
    private String description;
    private String duration;
    private String name;
    private String price;
    private String timeInCal;

    public Service() {
        // Default constructor required for Firestore
    }

    public Service(String description, String duration, String name, String price, String timeInCal) {
        this.description = description;
        this.duration = duration;
        this.name = name;
        this.price = price;
        this.timeInCal = timeInCal;
    }

    // Getter and setter methods for the attributes

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTimeInCal() {
        return timeInCal;
    }

    public void setTimeInCal(String timeInCal) {
        this.timeInCal = timeInCal;
    }
}
