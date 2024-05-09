package org.LaunchCode.codingevents.controllers;

import org.LaunchCode.codingevents.data.EventData;
import org.LaunchCode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    @GetMapping
    public String showAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("/create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:/events";
    }

    @PostMapping("/delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:/events";
    }

    @GetMapping("/edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        if (eventToEdit == null) {
            return "redirect:/events";
        }
        model.addAttribute("event", eventToEdit);
        String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
        model.addAttribute("title", title);
        return "events/edit";
    }

    @PostMapping("/edit")
    public String processEditForm(@RequestParam int eventId, @RequestParam String name, @RequestParam String description) {
        Event eventToEdit = EventData.getById(eventId);
        if (eventToEdit != null) {
            eventToEdit.setName(name);
            eventToEdit.setDescription(description);
        }
        return "redirect:/events";
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("title", "Coding Events");
        return "index";
    }

    @GetMapping("/delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }
}
