package com.parking.vehicle;

public interface Vehicle {


    Colour getColour() ;

    Vehicle colour(Colour colour) ;

    Size getSize() ;

    Vehicle size(Size size) ;

    String getRegistrationNumber() ;

    Vehicle registrationNumber(String registrationNumber) ;

}
