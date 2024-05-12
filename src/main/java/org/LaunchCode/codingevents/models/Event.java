package org.LaunchCode.codingevents.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Size(max = 500)
    private String description;

    // Default constructor for creating an event with a unique ID
    public Event() {
        synchronized (Event.class) {
            this.id = nextId;
            nextId++;
        }
    }

    // Constructor for creating an event with a name and description
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
