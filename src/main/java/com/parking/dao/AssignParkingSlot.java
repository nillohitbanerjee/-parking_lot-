package com.parking.dao;

import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AssignParkingSlot {


    private static Map<Vehicle, Slot> vehicleSlotMap = new ConcurrentHashMap<>();

    public static  Map<Vehicle, Slot> getCurrentStatusOfSystem(){

        return vehicleSlotMap;
    }

    private AssignParkingSlot(){}
}
