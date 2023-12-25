package br.com.quicula.omnicommunicator.domain.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import br.com.quicula.omnicommunicator.domain.Main;

/**
 * Utility class for printing the application banner.
 * 
 * <p>
 * This class contains a method for printing the application banner
 * that is stored as a resource in the application. The banner is 
 * printed to the standard output.
 * </p>
 */
public class PrintBanner {

    /**
     * Private constructor to prevent instantiation.
     */
    private PrintBanner() {}

    /**
     * Prints the application banner to the standard output.
     * 
     * <p>
     * This method reads the banner file line by line from the resources
     * and prints each line to the standard output. If an error occurs
     * while reading the file, an error message is printed to the standard
     * output and the stack trace is printed to the standard error.
     * </p>
     */
    public static void printBanner() {
        try {
            InputStream is = Main.class.getResourceAsStream("/banner_standard.txt");
            Objects.requireNonNull(is, "The banner file could not be found.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("An error occurred while reading the banner file.");
            e.printStackTrace();
        }
    }
}