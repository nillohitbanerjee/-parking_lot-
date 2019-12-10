package com.parking.commandCenter;

import com.parking.parking.ParkingLot;
import com.parking.vehicle.Vehicle;

public class Park implements Command {

    ParkingLot  parkingLot;
    Vehicle vehicle;

    public Park(Vehicle vehicle , ParkingLot parkingLot){
        this.parkingLot=parkingLot;
        this.vehicle=vehicle;
    }
    @Override
    public void execute() {
        parkingLot.park(vehicle);
    }
}
