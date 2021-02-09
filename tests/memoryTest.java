package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import memory.memoryManager;
import src.Task;

@Testable
public class memoryTest {
    @Test
    public void testWriteMemory() {
        // Setup
        String name = "Task 1";
        LocalDateTime date = LocalDateTime.of(2020, 12, 3, 4, 5);
        Task task = new Task(name, date);

        String expectedHeader = "Name,Date";
        String expectedLine = "";

        memoryManager.addTask(task);
        memoryManager.enableDebugMode();

        // Invoke
        memoryManager.writeMemory();

        // Analyze
        try {
            FileReader fileReader = new FileReader("tests/testMemory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String header = bufferedReader.readLine();
            String line = bufferedReader.readLine();

            assertEquals(expectedHeader, header);
            assertEquals(expectedLine, line);

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            assert(false);
        } catch (IOException e) {
            assert(false);
        }
    }
}
