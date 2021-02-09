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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Task == false) {
            return false;
        }

        Task other = (Task) o;
        
        return this.name.equals(other.name) && this.date.equals(other.date);
    }
}