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

    @Test
    public void testCreateAnotherTask() {
        // Setup
        String name = "Homework Assignment #2";
        LocalDate date = LocalDate.of(1992, 9, 20);

        // Invoke
        Task task = new Task(name, date);

        // Analyze
        assertEquals(name, task.getName());
        assertEquals(date, task.getDate());
    }
}
