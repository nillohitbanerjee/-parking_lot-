package com.parking.commandCenter;

import com.parking.parking.ParkingLot;
import com.parking.vehicle.Vehicle;

public class Status implements Command {

    ParkingLot  parkingLot;


    public Status(ParkingLot parkingLot){
        this.parkingLot=parkingLot;

    }
    @Override
    public void execute() {
        parkingLot.status();
    }
}
