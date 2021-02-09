package src;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate due;

    public Task(String name, LocalDate due) {
        this.name = name;
        this.due = due;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDue() {
        return this.due;
    }
}