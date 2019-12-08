package com.parking.parkingmanager;

import com.parking.commandCenter.CommandUtil;
import com.parking.commandCenter.Commands;
import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public final class Util {

    public static final void  processFile (String filePath){

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int count=0;
            ParkingLot parkingLot= null;
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();

                if(line.contains(Commands.create_parking_lot.name()) && count ==0){
                    count++;
                    parkingLot= intializeSystem(line);
                }
                if(line.contains(Commands.park.name())){

                    CommandUtil.park(parkingLot);
                }
                if(line.contains(Commands.leave.name())){
                    CommandUtil.leave(parkingLot);
                }
                if(line.contains(Commands.status.name())){
                    CommandUtil.status(parkingLot);
                }
                if(line.contains(Commands.registration_numbers_for_cars_with_colour.name())){
                    CommandUtil.registrationNumbersForCarsWithColour(parkingLot);
                }
                if(line.contains(Commands.slot_numbers_for_cars_with_colour.name())){
                    CommandUtil.slotNumbersForCarsWithColour(parkingLot);
                }
                if(line.contains(Commands.slot_number_for_registration_number.name())){
                    CommandUtil.slotNumberForRegistrationNumber(parkingLot);
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ParkingLot intializeSystem(String line) {

        String[] temp = line.split(" ");

        int numberOfParkingSpace = Integer.parseInt(temp[1]);

        ParkingLot parkingLot = new ParkingLot();

        parkingLot.setMaxSize(numberOfParkingSpace);
        Slot[] slots = new Slot[numberOfParkingSpace];
        Stack<Integer> emptySlots = new Stack<>();
        for (int i =numberOfParkingSpace; i>0; i--){
            emptySlots.push(i);
        }

        Stack<Integer> filledSlots = new Stack<>();

        parkingLot.setEmptySlots(emptySlots);
        parkingLot.setFilledSlots(filledSlots);
        parkingLot.setSlots(slots);


        return parkingLot;

    }
}
