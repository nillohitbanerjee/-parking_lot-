package com.parking.vehicle;

public interface Vehicle {


    String getColour() ;

    Vehicle colour(String colour) ;

    Size getSize() ;

    Vehicle size(Size size) ;

    String getRegistrationNumber() ;

    Vehicle registrationNumber(String registrationNumber) ;

}
