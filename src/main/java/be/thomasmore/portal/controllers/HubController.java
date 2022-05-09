package be.thomasmore.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class HubController {

    @GetMapping({"/hub/{user}"})
    public String home(Model model, String user) {

        return "hub";
    }
}
