package com.parking.parking;

import com.parking.vehicle.Vehicle;

import java.util.Stack;

public interface ParkingLot {

    public  void park(Vehicle vehicle);
    public  void leave(Vehicle vehicle) ;
    public  void empty(Slot slot);
    public  void status() ;
    public  void registrationNumbersForCarsWithColour(String colour) ;
    public  void slotNumbersForCarsWithColour(String colour) ;
    public  void slotNumberForRegistrationNumber(String registrationNumber) ;
    public int getMaxSize();
    public Slot[] getSlots();
    public Stack<Integer> getEmptySlots();

}
