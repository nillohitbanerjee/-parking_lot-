package com.parking.parkingmanager;

import com.parking.commandCenter.CheckValidPath;
import com.parking.exceptions.InvalidCommandArguments;

public class ParkingManager {

    public  static void main(String args[]){

        try {
            if (args.length > 1)
                throw new InvalidCommandArguments("Sorry! Maximum number of arguments exists the limit");
            else if (args.length == 1) {
                if (!CheckValidPath.isPathValid(args[0]))
                throw new InvalidCommandArguments("Sorry! Invalid path");
                else
                    Util.processFile(args[0]);
            }
           // else
                   // intializeSystem();
        }
        catch (InvalidCommandArguments ic){
            System.out.println(ic.getMessage());
        }
    }
}
