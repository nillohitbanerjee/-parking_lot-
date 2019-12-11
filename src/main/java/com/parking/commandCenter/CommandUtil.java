package com.parking.commandCenter;

import com.parking.dao.AssignParkingSlot;
import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;
import com.parking.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CommandUtil {

    public static int park(ParkingLot parkingLot, Vehicle vehicle) {

        if(AssignParkingSlot.getCurrentStatusOfSlot().size()==parkingLot.getMaxSize()) {
            System.out.println("Sorry, parking lot is full");
            return 0;
        }
        else{
           int slotToBeFilled =  parkingLot.getEmptySlots().pop();
            AssignParkingSlot.getCurrentStatusOfSlot().put(parkingLot.getSlots()[slotToBeFilled],vehicle);
            AssignParkingSlot.getCurrentStatusOfVechile().put(vehicle,parkingLot.getSlots()[slotToBeFilled]);
            System.out.println("Allocated slot number: "+(parkingLot.getSlots()[slotToBeFilled].getNumber()));
            return parkingLot.getSlots()[slotToBeFilled].getNumber();
        }
    }

    public static int leave(ParkingLot parkingLot, Vehicle vehicle) {
        if(parkingLot.getEmptySlots().size()==parkingLot.getMaxSize()){
            System.out.println("Sorry, parking is already empty");
            return 0;

        }
        else{

            Slot slotToBeEmpty= AssignParkingSlot.getCurrentStatusOfVechile().get(vehicle);
            parkingLot.getEmptySlots().push(slotToBeEmpty.getNumber());
            AssignParkingSlot.getCurrentStatusOfVechile().remove(vehicle);
            AssignParkingSlot.getCurrentStatusOfSlot().remove(slotToBeEmpty);
            System.out.println("Slot number "+slotToBeEmpty.getNumber()+" is free");
            return slotToBeEmpty.getNumber();
        }
    }

    public static boolean status(ParkingLot parkingLot) {


        System.out.format("%s%22s%10s", "Slot No.", "Registration No", "Colour\n");

        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        slotVehicleMap.forEach((slot,vehicle)->{
            System.out.format("%s%27s%11s",  slot.getNumber(),vehicle.getRegistrationNumber(),vehicle.getColour()+"\n");
        });

        return true;

    }

    public static String registrationNumbersForCarsWithColour(ParkingLot parkingLot, String colour) {
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        StringBuilder stringBuilder = new StringBuilder();
        slotVehicleMap.forEach((slot,vehicle)->{
            if(vehicle.getColour().equalsIgnoreCase(colour)) {
                stringBuilder.append(vehicle.getRegistrationNumber()).append(",").append(" ");

            }
        });

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(", "));
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String slotNumbersForCarsWithColour(ParkingLot parkingLot, String colour) {
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        StringBuilder stringBuilder = new StringBuilder();
        slotVehicleMap.forEach((slot,vehicle)->{
            if(vehicle.getColour().equalsIgnoreCase(colour))
                stringBuilder.append(slot.getNumber()).append(",").append(" ");
        });

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(", "));
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String slotNumberForRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
        Map<Slot, Vehicle> slotVehicleMap = AssignParkingSlot.getCurrentStatusOfSlot();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> reg = new ArrayList<>();
        slotVehicleMap.forEach((slot,vehicle)->{
            if(vehicle.getRegistrationNumber().equals(registrationNumber)) {
                stringBuilder.append(slot.getNumber()).append(",").append(" ");
                reg.add(registrationNumber);
            }


        });

        if(0==reg.size()){
            System.out.println("Not found");
            return "";
        }
        else{
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(", "));
            System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
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
