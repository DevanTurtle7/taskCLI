package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import src.Task;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TaskTest {
    @Test
    public void testCreateTask() {
        // Setup
        String name = "Homework Assignment #1";
        int year = 2002;
        int month = 3;
        int day = 18;
        int hour = 13;
        int minute = 59;
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, minute);

        // Invoke
        Task task = new Task(name, date);
        LocalDateTime actualDate = task.getDate();

        // Analyze
        assertEquals(name, task.getName());
        assertEquals(date, actualDate);
        assertEquals(year, actualDate.getYear());
        assertEquals(month, actualDate.getMonthValue());
        assertEquals(day, actualDate.getDayOfMonth());
        assertEquals(hour, actualDate.getHour());
        assertEquals(minute, actualDate.getMinute());
    }

    @Test
    public void testCreateAnotherTask() {
        // Setup
        String name = "Homework Assignment #2";
        int year = 1992;
        int month = 9;
        int day = 20;
        int hour = 3;
        int minute = 0;
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, minute);

        // Invoke
        Task task = new Task(name, date);
        LocalDateTime actualDate = task.getDate();

        // Analyze
        assertEquals(name, task.getName());
        assertEquals(date, actualDate);
        assertEquals(year, actualDate.getYear());
        assertEquals(month, actualDate.getMonthValue());
        assertEquals(day, actualDate.getDayOfMonth());
        assertEquals(hour, actualDate.getHour());
        assertEquals(minute, actualDate.getMinute());
    }
}