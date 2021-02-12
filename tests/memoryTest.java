package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import memory.MemoryManager;
import src.Task;

@Testable
public class MemoryTest {
    String path = absolutePath.getPath();

    @Test
    public void testWriteMemory() {
        // Setup
        MemoryManager.enableDebugMode(path);
        MemoryManager.clearMemory();

        String name = "Task 1";
        LocalDateTime date = LocalDateTime.of(2020, 12, 3, 4, 5);
        Task task = new Task(name, date);

        String expectedHeader = "Name,Date";
        String expectedLine = "Task 1,2020-12-03T04:05";

        MemoryManager.addTask(task);

        // Invoke
        MemoryManager.writeMemory();

        // Analyze
        try {
            FileReader fileReader = new FileReader(path + "tests/testMemory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String header = bufferedReader.readLine();
            String line = bufferedReader.readLine();

            assertEquals(expectedHeader, header);
            assertEquals(expectedLine, line);

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            assert(false);
        }
    }

    @Test
    public void testReadMemory() {
        // Setup
        MemoryManager.enableDebugMode(path);
        String name = "Task Name";
        LocalDateTime date = LocalDateTime.of(2002, 3, 18, 13, 45);
        Task expectedTask = new Task(name, date);

        try {
            FileWriter fileWriter = new FileWriter(path + "tests/testMemory.csv");
            fileWriter.write("Name,Date\n");
            fileWriter.write(name + ",2002-03-18T13:45\n");
            fileWriter.close();
        } catch (IOException e) {
            assert(false);
        }

        // Invoke
        MemoryManager.readMemory();
        Task task = MemoryManager.memory[0];

        // Analyze
        assertEquals(expectedTask, task);
    }
}