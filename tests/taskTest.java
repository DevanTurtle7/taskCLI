package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import src.Task;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class taskTest {
    @Test
    public void testCreateTask() {
        // Setup
        String name = "Homework Assignment #1";
        LocalDate date = LocalDate.of(2018, 2, 14);

        // Invoke
        Task task = new Task(name, date);

        // Analyze
        assertEquals(name, task.getName());
        assertEquals(date, task.getDate());
    }
}
