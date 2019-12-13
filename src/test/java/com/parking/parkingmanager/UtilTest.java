package com.parking.parkingmanager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(JUnit4.class)
public class UtilTest {

    @Test
    public void testProvessFile() throws FileNotFoundException {

        File inputXmlFile = new File(new ParkingManager().getClass().getResource("/parking_lot_file_inputs.txt").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());

         assert (Util.processFile(inputXmlFile.getPath()));
    }
}
