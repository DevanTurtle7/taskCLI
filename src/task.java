package src;

import java.util.Date;

public class task {
    private String name;
    private Date due;

    public task(String name, Date due) {
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
