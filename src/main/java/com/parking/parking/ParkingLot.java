package com.parking.parking;

import java.util.List;
import java.util.Stack;

public class ParkingLot {

    private Slot slots[];
    private Stack<Integer> emptySlots;
    private Stack<Integer> filledSlots;
    private int maxSize;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public Stack<Integer> getEmptySlots() {
        return emptySlots;
    }

    public void setEmptySlots(Stack<Integer> emptySlots) {
        this.emptySlots = emptySlots;
    }

    public Stack<Integer> getFilledSlots() {
        return filledSlots;
    }

    public void setFilledSlots(Stack<Integer> filledSlots) {
        this.filledSlots = filledSlots;
    }
}
