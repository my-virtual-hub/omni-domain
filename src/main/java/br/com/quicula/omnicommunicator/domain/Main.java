package br.com.quicula.omnicommunicator.domain;

import br.com.quicula.omnicommunicator.domain.utils.PrintBanner;

/**
 * This is the initialization class for the model layer.
 * It contains a static initialization block that is executed
 * when the class is loaded by the JVM.
 * 
 * <p>
 * Please note that the static initialization block will be executed
 * only once, when the class is first loaded.
 * </p>
 */
public class Main {
    
    private static final String INITIALIZER = initializer();

    /**
     * Returns the initialization message for the application.
     * 
     * @return the initialization message
     */
    public static String getInitializer() {
        return INITIALIZER;
    }

    /**
     * Initializes the application and returns an initialization message.
     * 
     * This method prints the application banner and returns a message
     * indicating that the application has started. This method is called
     * when the class is loaded to initialize the static field `initializer`.
     * 
     * @return a message indicating that the application has started
     */
    private static String initializer(){
        PrintBanner.printBanner();
        return "Omni Communicator Domain Layer started!";
    }

    /**
     * The entry point for the application.
     * 
     * This method prints the initialization message to the standard output.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(getInitializer());
    }
}