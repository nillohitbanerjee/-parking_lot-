package com.parking.parkingmanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

@RunWith(JUnit4.class)
public class ParkingManagerTest {

    @Test
    public void testMain() throws FileNotFoundException {

        File inputXmlFile = new File(this.getClass().getResource("/parking_lot_file_inputs.txt").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream is = loader.getResourceAsStream("/parking_lot_file_inputs.txt");

        URL url = getClass().getResource("/parking_lot_file_inputs.txt");
        System.out.println(url.getPath());
        new FileReader(url.getFile());
        String [] args={inputXmlFile.getAbsolutePath()};
        ParkingManager.main(args);
    }
}
