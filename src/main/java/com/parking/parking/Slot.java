package com.parking.parking;

public class Slot {

    private int number;

    private SlotType slotType;

    public int getNumber() {
        return number;
    }

    public Slot number(int number) {
        this.number = number;
        return this;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public Slot slotType(SlotType slotType) {
        this.slotType = slotType;
        return this;
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Slot)) {
            return false;
        }

        Slot slot = (Slot) o;

        return slot.slotType ==(slotType) &&
                slot.number == number;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + number;
        result = 31 * result + slotType.hashCode();
        return result;
    }
}
