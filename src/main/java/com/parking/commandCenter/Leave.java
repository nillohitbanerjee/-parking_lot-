package com.parking.commandCenter;

import com.parking.parking.ParkingLot;
import com.parking.vehicle.Vehicle;

public class Leave implements Command {

    ParkingLot  parkingLot;
    Vehicle vehicle;

    public Leave(Vehicle vehicle , ParkingLot parkingLot){
        this.parkingLot=parkingLot;
        this.vehicle=vehicle;
    }
    @Override
    public void execute() {
        parkingLot.leave(vehicle);
    }
}
