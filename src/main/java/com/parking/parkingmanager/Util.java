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
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public final class Util {

    public static  void  processFile (String filePath){

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File(filePath)));
            String line = reader.readLine();
            int count=0;
            ParkingLot parkingLot= null;
            while (line != null) {
                ProcessInstruction processInstruction = new ProcessInstruction(line, count, parkingLot).invoke();
                count = processInstruction.getCount();
                parkingLot = processInstruction.getParkingLot();
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

    public static void takeInputCommand() {

        int count=0;
        ParkingLot parkingLot= null;

        while (true) {

            Scanner sc = new Scanner(System.in);

            // String input
            String line = sc.nextLine();
            if(line.equalsIgnoreCase("exit"))
                System.exit(0);
            ProcessInstruction processInstruction = new ProcessInstruction(line, count, parkingLot).invoke();
            count = processInstruction.getCount();
            parkingLot = processInstruction.getParkingLot();
        }

    }

    private static class ProcessInstruction {
        private String line;
        private int count;
        private ParkingLot parkingLot;

        public ProcessInstruction(String line, int count, ParkingLot parkingLot) {
            this.line = line;
            this.count = count;
            this.parkingLot = parkingLot;
        }

        public int getCount() {
            return count;
        }

        public ParkingLot getParkingLot() {
            return parkingLot;
        }

        public ProcessInstruction invoke() {
           try {
               Command command = null;

               if (line.contains(Commands.create_parking_lot.name()) && count == 0) {
                   count++;
                   parkingLot = initializeSystem(line);
               }
               else if (line.contains(Commands.create_parking_lot.name()) && count > 0) {
                   count++;
                   System.out.println("Sorry, Your parking is already created!!!!");
               } else if (parkingLot == null) {
                   System.out.println("Please, Create a parking First!!!!");
               } else if (parkingLot != null && line.contains(Commands.park.name())) {
                   ParkLeaveBean parkLeaveBean = doParkingOrLeave(line);
                   command = new Park(parkLeaveBean.getVehicle(), parkingLot);
               } else if (parkingLot != null && line.contains(Commands.leave.name())) {
                   ParkLeaveBean parkLeaveBean = doParkingOrLeave(line);
                   if (parkLeaveBean.getSlot() == null)
                       command = new Leave(parkLeaveBean.getVehicle(), parkingLot);
                   else
                       command = new Leave(parkLeaveBean.getSlot(), parkingLot);
               } else if (parkingLot != null && line.contains(Commands.status.name())) {
                   command = new Status(parkingLot);
               } else if (parkingLot != null && line.contains(Commands.registration_numbers_for_cars_with_colour.name())) {
                   command = new RegistrationNumbersForCarsWithColour(parkingLot, getInput(line));
               } else if (parkingLot != null && line.contains(Commands.slot_numbers_for_cars_with_colour.name())) {
                   command = new SlotNumbersForCarsWithColour(parkingLot, getInput(line));
               } else if (parkingLot != null && line.contains(Commands.slot_number_for_registration_number.name())) {
                   command = new SlotNumberForRegistrationNumber(parkingLot, getInput(line));
               } else {
                   System.out.println("Please, Enter valid instructions!!!!");
               }
               if (command != null)
                   command.execute();
           }
           catch (Exception e ){
               System.out.println("Please, Enter valid instructions , Or Previous instruction process to faild ::-"+e.getCause());
           }
            return this;
        }
    }
}
