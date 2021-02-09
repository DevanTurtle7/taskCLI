package src;

import java.time.LocalDateTime;

import memory.memoryManager;

public class inputHandler {
    /**
     * Handles input entered by the user
     * @param input The text entered by the user
     */
    public static void handleInput(String input) {
        String[] tokens = input.split(" "); // Tokenize the input
        int numArguments = tokens.length; // Get the number of arguments

        if (numArguments == 1) {
            String command = tokens[0].toLowerCase(); // Convert the command to lowercase so case doesn't matter

            if (command.equals("exit") || command.equals("quit")) {
                _main.exitProgram(); // Exit the program
            } else if (command.equals("save")) {
                memoryManager.writeMemory();
            } else if (command.equals("c")) {
                LocalDateTime date = LocalDateTime.now();
                Task task = new Task("Test", date);
                memoryManager.addTask(task);
                memoryManager.writeMemory();
            }
        }
    }
}