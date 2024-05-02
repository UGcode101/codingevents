package org.LaunchCode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")  // Optional: Define the base URL for all requests handled by this controller
public class HomeController {

    @GetMapping
    public String index() {
        return "index";  // Name of the template to render (assumes a template named "index" exists)
    }
}