/**
 * This file makes it easier for the user to start this program from the
 * command line. They can simply enter "java taskCLI" instead of having
 * to call a file in another directory. This file simply calls another
 * file.
 * 
 * @author Devan Kavalchek
 */

import src._main; // Import the main file

public class taskCLI {
    public static void main(String[] args) {
        _main.main(args); // Run the program
    }
}