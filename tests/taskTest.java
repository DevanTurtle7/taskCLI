package tests;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class taskTest {
    @Test
    public void testCreateTask() {
        // Setup
        String name = "Homework Assignment #1";
        LocalDate date = LocalDate.of(2018, 2, 14);
    }
}
