package org.LaunchCode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private List<String> events = new ArrayList<>(); // A simple list to store events

    // Method to display all events
    @GetMapping
    public String showEvents(Model model) {
        model.addAttribute("events", events);
        return "events/index";  // Points to /templates/events/index.html
    }

    // Method to display the form for creating a new event
    @GetMapping("/create")
    public String showCreateForm() {
        return "events/create";  // Assumes you have a create.html in src/main/resources/templates/events/
    }

    // Method to handle the creation of a new event
    @PostMapping("/create")
    public String addEvent(@RequestParam String eventName, Model model) {
        events.add(eventName);  // Add the new event to the list
        return "redirect:/events";  // Redirect to the GET handler which shows the list
    }
}