package com.parking.parkingmanager;

import com.parking.commandCenter.Commands;
import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Util {

    public static final void  processFile (String filePath){

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int count=0;
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();

                if(line.contains(Commands.create_parking_lot.name()) && count ==0){
                    count++;
                    intializeSystem(line);
                }
                if(line.contains(Commands.park.name())){

                    intializeSystem(line);
                }
                if(line.contains(Commands.leave.name())){
                    count++;
                    intializeSystem(line);
                }
                if(line.contains(Commands.create_parking_lot.name())){
                    count++;
                    intializeSystem(line);
                }
                if(line.contains(Commands.create_parking_lot.name())){
                    count++;
                    intializeSystem(line);
                }
                if(line.contains(Commands.create_parking_lot.name())){
                    count++;
                    intializeSystem(line);
                }
                if(line.contains(Commands.create_parking_lot.name())){
                    count++;
                    intializeSystem(line);
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void intializeSystem(String line) {

        String temp [] = line.split(" ");

        int numberOfParkingSpace = Integer.parseInt(temp[1]);

        ParkingLot parkingLot = new ParkingLot();

        parkingLot.setMaxSize(numberOfParkingSpace);
        List<Slot> slots = new ArrayList<>();
        Stack<Integer> emptySlots = new Stack<>();
        for (int i =numberOfParkingSpace; i>0; i++){
            emptySlots.push(i);
        }

        Stack<Integer> filledSlots = new Stack<>();

        parkingLot.setEmptySlots(emptySlots);
        parkingLot.setFilledSlots(filledSlots);
        parkingLot.setSlots(slots);



    }
}
