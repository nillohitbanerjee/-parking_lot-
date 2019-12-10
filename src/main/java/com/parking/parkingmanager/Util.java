package com.parking.parkingmanager;

import com.parking.commandCenter.*;
import com.parking.parking.MyParkingLot;
import com.parking.parking.ParkingLot;
import com.parking.parking.Slot;
import com.parking.parking.SlotType;
import com.parking.vehicle.Car;
import com.parking.vehicle.Size;
import com.parking.vehicle.Vehicle;

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
               // System.out.println(line);


                if(line.contains(Commands.create_parking_lot.name()) && count ==0){
                    count++;
                    parkingLot= initializeSystem(line);
                }
                else if(line.contains(Commands.park.name())){
                    ParkLeaveBean parkLeaveBean = doParkingOrLeave(line);
                    command = new Park(parkLeaveBean.getVehicle(),parkingLot);
                }
                else if(line.contains(Commands.leave.name())){
                    ParkLeaveBean parkLeaveBean = doParkingOrLeave(line);
                    if(parkLeaveBean.getSlot()==null)
                        command = new Leave(parkLeaveBean.getVehicle(),parkingLot);
                    else
                        command = new Leave(parkLeaveBean.getSlot(),parkingLot);
                }
                else if(line.contains(Commands.status.name())){
                    command = new Status(parkingLot);
                }
                else if(line.contains(Commands.registration_numbers_for_cars_with_colour.name())){
                    command = new RegistrationNumbersForCarsWithColour(parkingLot,getInput(line));
                }
                else if(line.contains(Commands.slot_numbers_for_cars_with_colour.name())){
                    command = new SlotNumbersForCarsWithColour(parkingLot,getInput(line));
                }
                else if(line.contains(Commands.slot_number_for_registration_number.name())){
                    command = new SlotNumberForRegistrationNumber(parkingLot,getInput(line));
                }

                if(command!=null)
                    command.execute();
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getInput(String line) {
        String[] temp = line.split(" ");
        return temp[1];
    }

    private static ParkLeaveBean doParkingOrLeave(String line) {

        ParkLeaveBean parkLeaveBean = new ParkLeaveBean();
        String[] temp = line.split(" ");
        if(temp.length==3){
            Vehicle vehicle = new Car();
            vehicle.size(Size.FourWheeler).registrationNumber(temp[1]).colour(temp[2]);
            parkLeaveBean.setVehicle(vehicle);
        }
        if(temp.length==2){
            Slot slot = new Slot();
            slot.number(Integer.parseInt(temp[1])).slotType(SlotType.CAR);
            parkLeaveBean.setSlot(slot);
        }
        return parkLeaveBean;
    }

    private static ParkingLot initializeSystem(String line) {

        String[] temp = line.split(" ");

        int numberOfParkingSpace = Integer.parseInt(temp[1]);

        ParkingLot parkingLot = new MyParkingLot(numberOfParkingSpace);
        System.out.println("Created a parking lot with "+numberOfParkingSpace+" slots");
        return parkingLot;

    }
}
