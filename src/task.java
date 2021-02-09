package src;

import java.time.LocalDateTime;

public class Task {
    private String name;
    private LocalDateTime date;

    /**
     * The constructor
     * @param name The name of the task
     * @param date The date the task is due
     */
    public Task(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    /**
     * An accessor for name
     * @return The tasks name
     */
    public String getName() {
        return this.name;
    }

    /**
     * An accessor for date
     * @return The date
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Returns true if the other object is equal to this object
     * @param Object The other object being compared
     * @return Whether or not the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Task == false) {
            return false;
        }

        Task other = (Task) o;
        
        return this.name.equals(other.name) && this.date.equals(other.date);
    }
}