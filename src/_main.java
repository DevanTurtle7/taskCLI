package src;

import java.util.Scanner;
import memory.memory;

public class _main {
    private static boolean exit = false; // Tells the program when to end

    /**
     * The main function. Called on startup.
     * @param args Arguments passed in by the system.
     */
    public static void main(String args[]) {
        // Load data
        memory.readMemory();

        // Print welcome message

        // Handle user input
        Scanner inputScanner = new Scanner(System.in);

        while (!exit) { // Continue looping until the user exits the program
            System.out.print("taskCLI: "); // Print a command prompt
            String input = inputScanner.nextLine();
            System.out.println("The user entered: " + input);

            inputHandler.handleInput(input);
        }

        inputScanner.close();
    }

    /**
     * Exits the program.
     */
    public static void exitProgram() {
        exit = true;
    }
}
