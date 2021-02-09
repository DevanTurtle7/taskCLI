package src;

import java.time.LocalDateTime;

public class Task {
    private String name;
    private LocalDateTime date;

    public Task(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getDate() {
        return this.date;
    }
}