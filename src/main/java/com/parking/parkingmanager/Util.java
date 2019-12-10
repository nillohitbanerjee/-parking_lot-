package com.parking.parkingmanager;

import com.parking.commandCenter.*;
import com.parking.parking.MyParkingLot;
import com.parking.parking.ParkingLot;

import java.io.BufferedReader;
import java.io.FileReader;

public final class Util {

    public static final void  processFile (String filePath){

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int count=0;
            ParkingLot parkingLot= null;
            while (line != null) {
                Command command =null;
                System.out.println(line);
                line = reader.readLine();

                if(line.contains(Commands.create_parking_lot.name()) && count ==0){
                    count++;
                    parkingLot= initializeSystem(line);
                }
                if(line.contains(Commands.park.name())){
                    ParkLeaveBean parkLeaveBean = doParkingOrLeave(line);
                    command = new Park(parkLeaveBean.getVehicle(),parkLeaveBean.getParkingLot());
                }
                if(line.contains(Commands.leave.name())){
                    ParkLeaveBean parkLeaveBean = doParkingOrLeave(line);
                    command = new Leave(parkLeaveBean.getVehicle(),parkLeaveBean.getParkingLot());
                }
                if(line.contains(Commands.status.name())){
                    command = new Status(parkingLot);
                }
                if(line.contains(Commands.registration_numbers_for_cars_with_colour.name())){
                    command = new RegistrationNumbersForCarsWithColour(parkingLot,getInput(line));
                }
                if(line.contains(Commands.slot_numbers_for_cars_with_colour.name())){
                    command = new SlotNumbersForCarsWithColour(parkingLot,getInput(line));
                }
                if(line.contains(Commands.slot_number_for_registration_number.name())){
                    command = new SlotNumberForRegistrationNumber(parkingLot,getInput(line));
                }

                if(command!=null)
                    command.execute();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getInput(String line) {
        return null;
    }

    private static ParkLeaveBean doParkingOrLeave(String line) {

        return null;
    }

    private static ParkingLot initializeSystem(String line) {

        String[] temp = line.split(" ");

        int numberOfParkingSpace = Integer.parseInt(temp[1]);

        ParkingLot parkingLot = new MyParkingLot(numberOfParkingSpace);

        return parkingLot;

    }
}
