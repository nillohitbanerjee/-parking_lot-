package com.parking.commandCenter;

import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

public class Leave implements Command {

    ParkingLot  parkingLot;
    Vehicle vehicle;
    Slot slot;


    public Leave(Vehicle vehicle , ParkingLot parkingLot){
        this.parkingLot=parkingLot;
        this.vehicle=vehicle;
    }
    public Leave(Slot slot , ParkingLot parkingLot){
        this.parkingLot=parkingLot;
        this.slot=slot;
    }
    @Override
    public void execute() {
        if(null==slot)
             parkingLot.leave(vehicle);
        else
            parkingLot.empty(slot);
    }
}
