package com.parking.commandCenter;

import com.parking.parking.MyParkingLot;
import com.parking.parking.ParkingLot;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
class CommandUtilTest {

    ParkingLot parkingLot;
    @Before
    public void init() {

        ParkingLot parkingLot = new MyParkingLot(6);
    }

    void testPark() {
    }

    void testLeave() {
    }

    void testStatus() {
    }

    void testRegistrationNumbersForCarsWithColour() {
    }

    void testSlotNumbersForCarsWithColour() {
    }

    void testSlotNumberForRegistrationNumber() {
    }

    void testEmpty() {
    }
}
