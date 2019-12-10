package com.parking.commandCenter;

import com.parking.parking.ParkingLot;

public class SlotNumbersForCarsWithColour implements Command {

    ParkingLot  parkingLot;
    String colour;

    public SlotNumbersForCarsWithColour(ParkingLot parkingLot, String colour){
        this.parkingLot=parkingLot;
        this.colour=colour;

    }
    @Override
    public void execute() {
        parkingLot.slotNumbersForCarsWithColour(colour);
    }
}
