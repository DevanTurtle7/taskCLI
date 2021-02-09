package memory;

import java.io.FileWriter;
import java.io.IOException;

import src._main;
import src.Task;

public class memoryManager {

    private static Task[] memory = new Task[100]; // An array where tasks are stored
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

    public static void readMemory() {

    };

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

    public static void enableDebugMode(String path) {
        filename = path + "tests/testMemory.csv";
    }
}
