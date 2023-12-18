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
    
    private static String initializer = initializer();

    public static String getInitializer() {
        return initializer;
    }

    private static String initializer(){
        PrintBanner.printBanner();
        return "Omni Communicator Domain Layer started!";
    }

    public static void main(String[] args) {
        System.out.println(getInitializer());
    }
}
