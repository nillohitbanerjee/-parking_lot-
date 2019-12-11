package com.parking.commandCenter;

import com.parking.parking.MyParkingLot;
import com.parking.parking.ParkingLot;
import com.parking.vehicle.Car;
import com.parking.vehicle.Size;
import com.parking.vehicle.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CommandUtilTest {

    ParkingLot parkingLot;
    @Before
    public void init() {

        parkingLot = new MyParkingLot(6);
    }

    @Test
    public void testPark() {
        Vehicle car = new Car();
        car.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slot = CommandUtil.park(parkingLot,car);

        assert (slot==1);


    }

    @Test
    public void testLeave() {
        Vehicle car = new Car();
        car.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slot = CommandUtil.park(parkingLot,car);



        Vehicle removecar = new Car();
        removecar.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slotnumber = CommandUtil.leave(parkingLot,removecar);

        assert (slotnumber==1);
    }

    @Test
    public void testStatus() {

        Vehicle car = new Car();
        car.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slot = CommandUtil.park(parkingLot,car);
        assert(CommandUtil.status(parkingLot));


    }

    @Test
    public void testRegistrationNumbersForCarsWithColour() {

        Vehicle car = new Car();
        car.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slot = CommandUtil.park(parkingLot,car);
        String reg = CommandUtil.registrationNumbersForCarsWithColour(parkingLot,"white");
        assert(reg.trim().equals("abc"));

    }


    @Test
    public void testSlotNumbersForCarsWithColour() {

        Vehicle car = new Car();
        car.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slot = CommandUtil.park(parkingLot,car);
        String reg = CommandUtil.slotNumbersForCarsWithColour(parkingLot,"white");
        assert(reg.trim().equals("1"));
    }

    @Test
    public void testSlotNumberForRegistrationNumber() {
        Vehicle car = new Car();
        car.size(Size.FourWheeler).colour("white").registrationNumber("abc");
        int slot = CommandUtil.park(parkingLot,car);
        String reg = CommandUtil.slotNumberForRegistrationNumber(parkingLot,"abc");
        assert(reg.trim().equals("1"));
    }


    public void testEmpty() {
    }
}
