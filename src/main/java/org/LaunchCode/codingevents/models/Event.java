package org.LaunchCode.codingevents.models;

public class Event {

    private int id;
    private static int nextId = 1;

    private String name;
    private String description;

    // Default constructor (needed for Spring form binding)
    public Event() {
        synchronized (Event.class) {
            this.id = nextId;
            nextId++;
        }
    }

    // Parameterized constructor
    public Event(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    // Remove unnecessary put method
}
