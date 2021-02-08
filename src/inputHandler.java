package src;

public class inputHandler {
    /**
     * Handles input entered by the user
     * @param input The text entered by the user
     */
    public static void handleInput(String input) {
        String[] tokens = input.split(" ");
        int numArguments = tokens.length;

        if (numArguments == 1) {
            String command = tokens[0].toLowerCase();

            if (command.equals("exit") || command.equals("quit")) {
                _main.exitProgram();
            }
        }
    }
}
