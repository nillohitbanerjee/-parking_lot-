package com.parking.vehicle;

public class Bike implements Vehicle{

    private Colour colour;
    private Size size;
    private String registrationNumber;


    public Colour getColour() {
        return colour;
    }

    public Vehicle colour(Colour colour) {
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
