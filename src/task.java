package src;

import java.util.Date;

public class Task {
    private String name;
    private Date due;

    public Task(String name, Date due) {
        this.name = name;
        this.due = due;
    }

    public String getName() {
        return this.name;
    }

    public Date getDue() {
        return this.due;
    }
}