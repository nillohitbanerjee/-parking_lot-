package com.parking.commandCenter;

import com.parking.parking.ParkingLot;

public class RegistrationNumbersForCarsWithColour implements Command {

    ParkingLot  parkingLot;
    String colour;


    public RegistrationNumbersForCarsWithColour(ParkingLot parkingLot, String colour){
        this.parkingLot=parkingLot;
        this.colour=colour;

    }
    @Override
    public void execute() {
        parkingLot.registrationNumbersForCarsWithColour(colour);
    }
}
