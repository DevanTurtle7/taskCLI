package memory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import src._main;
import src.Task;

public class memory {
    public static Task[] taskMemory = new Task[100];

    public static void writeMemory() {
        try {
            FileWriter fileWriter = new FileWriter("memory/memory.csv");
            fileWriter.write("Name,Date\n");

            for (Task task : taskMemory) {
                if (task != null) {
                    System.out.println("Writing");
                    fileWriter.write(task.getName() + "," + task.getDue().toString() + "\n");
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            _main.exitProgram();
        }
    }

    public static void readMemory() {

    };

    public static void addTask(Task task) {
        boolean indexFound = false;

        for (int i = 0; i < taskMemory.length; i++) {
            Task index = taskMemory[i];

            if (!indexFound) {
                if (index == null) {
                    indexFound = true;
                    taskMemory[i] = task;
                }
            }
        }
    }

    public static void removeTask() {

    }
}
