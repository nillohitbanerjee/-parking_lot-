package com.parking.commandCenter;

import com.parking.dao.AssignParkingSlot;
import com.parking.parking.MyParkingLot;
import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

public final class CommandUtil {

    public static void park(ParkingLot parkingLot, Vehicle vehicle) {

        if(AssignParkingSlot.getCurrentStatusOfSlot().size()==parkingLot.getMaxSize())
            System.out.println("Sorry, parking lot is full");
        else{
           int slotToBeFilled =  parkingLot.getEmptySlots().pop();
            AssignParkingSlot.getCurrentStatusOfSlot().put(parkingLot.getSlots()[slotToBeFilled],vehicle);
            AssignParkingSlot.getCurrentStatusOfVechile().put(vehicle,parkingLot.getSlots()[slotToBeFilled]);
            System.out.println("Allocated slot number: "+slotToBeFilled);
        }
    }

    public static void leave(ParkingLot parkingLot, Vehicle vehicle) {
        if(parkingLot.getEmptySlots().size()==parkingLot.getMaxSize()){
            System.out.println("Sorry, parking is already empty");

        }
        else{

            Slot slotToBeEmpty= AssignParkingSlot.getCurrentStatusOfVechile().get(vehicle);
            parkingLot.getEmptySlots().push(slotToBeEmpty.getNumber());
            AssignParkingSlot.getCurrentStatusOfVechile().remove(vehicle);
            AssignParkingSlot.getCurrentStatusOfSlot().remove(slotToBeEmpty);
            System.out.println("Slot number "+slotToBeEmpty.getNumber()+" is free");
        }
    }

    public static void status(ParkingLot parkingLot) {

    }

    public static void registrationNumbersForCarsWithColour(ParkingLot parkingLot, String colour) {
    }

    public static void slotNumbersForCarsWithColour(ParkingLot parkingLot, String colour) {
    }

    public static void slotNumberForRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
    }

    public static void empty(ParkingLot parkingLot, Slot slot) {

        if(parkingLot.getEmptySlots().size()==parkingLot.getMaxSize()){
            System.out.println("Sorry, parking is already empty");

        }
        else{
            parkingLot.getEmptySlots().push(slot.getNumber());
            Vehicle vehicleoBeRemoved= AssignParkingSlot.getCurrentStatusOfSlot().get(slot);
            AssignParkingSlot.getCurrentStatusOfVechile().remove(vehicleoBeRemoved);
            AssignParkingSlot.getCurrentStatusOfSlot().remove(slot);
            System.out.println("Slot number "+slot.getNumber()+" is free");
        }

    }
}
