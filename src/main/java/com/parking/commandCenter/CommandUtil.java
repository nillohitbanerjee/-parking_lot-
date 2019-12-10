package com.parking.commandCenter;

import com.parking.dao.AssignParkingSlot;
import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CommandUtil {

    public static void park(ParkingLot parkingLot, Vehicle vehicle) {

        if(AssignParkingSlot.getCurrentStatusOfSlot().size()==parkingLot.getMaxSize())
            System.out.println("Sorry, parking lot is full");
        else{
           int slotToBeFilled =  parkingLot.getEmptySlots().pop();
            AssignParkingSlot.getCurrentStatusOfSlot().put(parkingLot.getSlots()[slotToBeFilled],vehicle);
            AssignParkingSlot.getCurrentStatusOfVechile().put(vehicle,parkingLot.getSlots()[slotToBeFilled]);
            System.out.println("Allocated slot number: "+(parkingLot.getSlots()[slotToBeFilled].getNumber()));
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


        //System.out.format("%10s%20s%10s", "Slot No.", "Registration No", "Colour");
        System.out.println( "Slot No."+"Registration No"+ "Colour");
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        slotVehicleMap.forEach((slot,vehicle)->{
            System.out.println( slot.getNumber()+vehicle.getRegistrationNumber()+vehicle.getColour());
        });


    }

    public static void registrationNumbersForCarsWithColour(ParkingLot parkingLot, String colour) {
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        slotVehicleMap.forEach((slot,vehicle)->{
            if(vehicle.getColour().toString().equalsIgnoreCase(colour))
            System.out.print(vehicle.getRegistrationNumber() +", ");
        });

        System.out.println("");
    }

    public static void slotNumbersForCarsWithColour(ParkingLot parkingLot, String colour) {
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        slotVehicleMap.forEach((slot,vehicle)->{
            if(vehicle.getColour().toString().equalsIgnoreCase(colour))
                System.out.print(slot.getNumber() +", ");
        });
        System.out.println("");
    }

    public static void slotNumberForRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        List<String> reg = new ArrayList<>();
        slotVehicleMap.forEach((slot,vehicle)->{
            if(vehicle.getRegistrationNumber().equals(registrationNumber)) {
                System.out.print(slot.getNumber() + ", ");
                reg.add(registrationNumber);
            }


        });
        System.out.println("");
        if(reg.size()==0){
            System.out.println("Not found");
        }
    }

    public static void empty(ParkingLot parkingLot, Slot slot) {

        if(parkingLot.getEmptySlots().size()==parkingLot.getMaxSize()){
            System.out.println("Sorry, parking is already empty");

        }
        else{
            parkingLot.getEmptySlots().push(slot.getNumber()-1);
            Vehicle vehicleoBeRemoved= AssignParkingSlot.getCurrentStatusOfSlot().get(slot);
            AssignParkingSlot.getCurrentStatusOfVechile().remove(vehicleoBeRemoved);
            AssignParkingSlot.getCurrentStatusOfSlot().remove(slot);
            System.out.println("Slot number "+slot.getNumber()+" is free");
        }

    }
}
