package src;

public class inputHandler {
    /**
     * Handles input entered by the user
     * @param input The text entered by the user
     */
    public static void handleInput(String input) {
        input = input.toLowerCase(); // Convert the input to lowercase

        if (input.equals("exit") || input.equals("quit")) {
            _main.exitProgram(); // Exit the program
        }
    }
}
