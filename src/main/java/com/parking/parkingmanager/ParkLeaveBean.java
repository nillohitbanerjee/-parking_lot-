package com.parking.parkingmanager;

import com.parking.parking.ParkingLot;
import com.parking.vehicle.Vehicle;

public class ParkLeaveBean {

    private Vehicle vehicle;
    private ParkingLot parkingLot;

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

    public void setParkingLot(final ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
