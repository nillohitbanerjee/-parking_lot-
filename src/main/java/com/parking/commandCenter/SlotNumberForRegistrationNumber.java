package com.parking.commandCenter;

import com.parking.parking.ParkingLot;

public class SlotNumberForRegistrationNumber implements Command {

    ParkingLot  parkingLot;
    String registrationNumber;


    public SlotNumberForRegistrationNumber(ParkingLot parkingLot, String registrationNumber){
        this.parkingLot=parkingLot;
        this.registrationNumber= registrationNumber;

    }
    @Override
    public void execute() {
        parkingLot.slotNumberForRegistrationNumber(registrationNumber);
    }
}
