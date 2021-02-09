package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import memory.memoryManager;
import src.Task;

@Testable
public class memoryTest {
    String path = absolutePath.getPath();

    @Test
    public void testWriteMemory() {
        // Setup
        String name = "Task 1";
        LocalDateTime date = LocalDateTime.of(2020, 12, 3, 4, 5);
        Task task = new Task(name, date);

        String expectedHeader = "Name,Date";
        String expectedLine = "Task 1,2020-12-03T04:05";

        memoryManager.addTask(task);
        memoryManager.enableDebugMode(path);

        // Invoke
        memoryManager.writeMemory();

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
}