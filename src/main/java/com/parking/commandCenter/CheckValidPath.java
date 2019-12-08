package com.parking.commandCenter;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public final class CheckValidPath {

    public static boolean isPathValid(String path) {

        try {

            Paths.get(path);

        } catch (InvalidPathException ex) {
            return false;
        }

        return true;
    }
}
