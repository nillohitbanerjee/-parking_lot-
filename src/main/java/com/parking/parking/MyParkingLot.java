package com.parking.parking;

import com.parking.commandCenter.CommandUtil;
import com.parking.vehicle.Vehicle;

import java.util.Stack;

public class MyParkingLot implements ParkingLot {

    private Slot[] slots;
    private Stack<Integer> emptySlots;

    private int maxSize;

    public int getMaxSize() {
        return maxSize;
    }
    public Slot[] getSlots() {
        return slots;
    }
    public Stack<Integer> getEmptySlots() {
        return emptySlots;
    }



    public MyParkingLot(int size){

        this.maxSize=size;
        this.slots = new Slot[size];

        for (int i =0; i<size; i++){
            Slot slot = new Slot();
            slot.number(i+1).slotType(SlotType.CAR);
            slots[i]=slot;
        }


        this.emptySlots = new Stack<>();
        for (int i =size-1; i>=0; i--){
            emptySlots.push(i);
        }






    }
    @Override
    public void park(Vehicle vehicle) {

        CommandUtil.park(this,vehicle);
    }

    @Override
    public void leave(Vehicle vehicle) {
        CommandUtil.leave(this,vehicle);
    }

    @Override
    public void empty(Slot slot) {
        CommandUtil.empty(this,slot);
    }

    @Override
    public void status() {
        CommandUtil.status(this);
    }

    @Override
    public void registrationNumbersForCarsWithColour(String colour) {

        CommandUtil.registrationNumbersForCarsWithColour(this,colour);
    }

    @Override
    public void slotNumbersForCarsWithColour(String colour) {

        CommandUtil.slotNumbersForCarsWithColour(this,colour);
    }

    @Override
    public void slotNumberForRegistrationNumber(String registrationNumber) {

        CommandUtil.slotNumberForRegistrationNumber(this,registrationNumber);
    }
}
