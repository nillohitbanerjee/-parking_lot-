package com.parking.parking;

import com.parking.vehicle.Vehicle;

public interface ParkingLot {

    public  void park(Vehicle vehicle);
    public  void leave(Vehicle vehicle) ;
    public  void status() ;
    public  void registrationNumbersForCarsWithColour(String colour) ;
    public  void slotNumbersForCarsWithColour(String colour) ;
    public  void slotNumberForRegistrationNumber(String registrationNumber) ;
}
