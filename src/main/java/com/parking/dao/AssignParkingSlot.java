package com.parking.dao;

import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AssignParkingSlot {


    private static final Map<Vehicle, Slot> vehicleSlotMap = new ConcurrentHashMap<>();

    public static  Map<Vehicle, Slot> getCurrentStatusOfVechile(){

        return vehicleSlotMap;
    }

    private static final Map<Slot, Vehicle> slotVechileMap = new ConcurrentHashMap<>();

    public static  Map<Slot, Vehicle> getCurrentStatusOfSlot(){

        return slotVechileMap;
    }
    private AssignParkingSlot(){}
}
