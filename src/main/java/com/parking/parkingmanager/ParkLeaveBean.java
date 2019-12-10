package com.parking.parkingmanager;

import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

public class ParkLeaveBean {

    private Vehicle vehicle;

    private Slot slot;

    public Slot getSlot() {
        return this.slot;
    }

    public void setSlot(final Slot slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
