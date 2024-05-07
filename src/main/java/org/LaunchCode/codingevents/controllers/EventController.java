package org.LaunchCode.codingevents.controllers;

import org.LaunchCode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private static List<Event> events = new ArrayList<>();

    // Method to display all events
    @GetMapping
    public String showAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";  // Points to /templates/events/index.html
    }

    // Method to display the form for creating a new event
    @GetMapping("/create")
    public String showCreateForm() {
        return "events/create";  // Assumes you have a create.html in src/main/resources/templates/events/
    }

    @PostMapping("/create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.add(new Event(eventName, eventDescription));
        return "redirect:/events";
    }
}
