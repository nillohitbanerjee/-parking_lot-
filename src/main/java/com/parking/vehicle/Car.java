package com.parking.vehicle;

public class Car extends UniqueVechile {

    private String colour;
    private Size size;
    private String registrationNumber;

    public String getColour() {
        return colour;
    }

    public Vehicle colour(String colour) {
        this.colour = colour;
        return this;
    }

    public Size getSize() {
        return size;
    }

    public Vehicle size(Size size) {
        this.size = size;
        return this;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Vehicle registrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }
}
