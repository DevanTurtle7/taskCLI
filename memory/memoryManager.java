package memory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import src._main;
import src.Task;

public class memoryManager {

    public static Task[] memory = new Task[100]; // An array where tasks are stored
    private static String filename = "memory/memory.csv";

    /**
     * Saves all of the tasks in memory to memory.csv
     */
    public static void writeMemory() {
        try {
            FileWriter fileWriter = new FileWriter(filename); // Create a new file writer
            fileWriter.write("Name,Date\n"); // Write the header

            for (Task task : memory) { // Iterate over each task in the memory
                if (task != null) { // Make sure the current task exists
                    fileWriter.write(task.getName() + "," + task.getDate().toString() + "\n"); // Write the data
                }
            }

            fileWriter.close(); // Close the file writer
        } catch (IOException e) {
            // The memory.csv file cannot be read
            System.out.println("An error occurred");
            System.out.println(e);
            _main.exitProgram();
        }
    }

    /**
     * Loads the memory from memory.csv into the memory array
     */
    public static void readMemory() {
        try {
            FileReader fileReader = new FileReader(filename); // Create a file reader
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Create a buffered reader
            String line = bufferedReader.readLine(); // Get the first line (header)
            Arrays.fill(memory, null); // Clear the memory array
            int memoryPointer = 0; // Create a pointer

            line = bufferedReader.readLine(); // Move to the next line (skip the header)
            while (line != null) { // Loop over every line in the file
                String[] tokens = line.split(","); // Tokenize the line
                String name = tokens[0]; // Get the task name
                String dateStr = tokens[1]; // Get the task date
                LocalDateTime date = LocalDateTime.parse(dateStr); // Convert the string to a date
                Task task = new Task(name, date); // Create a task

                if (memoryPointer < memory.length) { // Make sure there is still space in the memory
                    memory[memoryPointer] = task; // Store the task in memory
                } else {
                    // Print an error message and exit
                    System.out.println("Memory file exceeds memory size");
                    break;
                }

                line = bufferedReader.readLine(); // Read the next line
            }

            // Close the readers
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            // Print an error message
            System.out.println("Error reading memory");
        }
    };
    
    /**
     * Clears the memory
     */
    public static void clearMemory() {
        Arrays.fill(memory, null); // Clear the memory array
        writeMemory(); // Clear the memory file by writing the empty array to the file
    }

    /**
     * Adds a task to taskMemory
     * @param task The task being added
     */
    public static void addTask(Task task) {
        // Initialize loop variables
        boolean indexFound = false;
        int i = 0;
        int memorySize = memory.length;

        while (!indexFound && i < memorySize) { // Loop until an index is found or the entire array has been checked
            Task index = memory[i]; // Get the current task

            if (index == null) { // Check if the index is empty
                memory[i] = task; // Put the task in the empty index
                indexFound = true; // Mark indexFound as true
            }

            i++; // Increment i
        }

        if (!indexFound) { // The array is full
            System.out.println("Error: The memory is full"); // Print a message
        }
    }

    public static void removeTask() {

    }

    /**
     * Changes the memory file path to a test file so that user data does not
     * get overwritten
     * @param path The absolute path to the taskCLI folder
     */
    public static void enableDebugMode(String path) {
        filename = path + "tests/testMemory.csv"; // Change the filename
    }
}
