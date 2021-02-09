package src;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate date;

    public Task(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDate() {
        return this.date;
    }
}