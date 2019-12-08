package com.parking.vehicle;

public interface Vehicle {


    public Colour getColour() ;

    public Vehicle colour(Colour colour) ;

    public Size getSize() ;

    public Vehicle size(Size size) ;

    public String getRegistrationNumber() ;

    public Vehicle registrationNumber(String registrationNumber) ;

}
