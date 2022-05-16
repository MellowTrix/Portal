package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping({"/contact"})
    public String contact(Model model) {
        ContactMessage contactMessage = new ContactMessage();
        model.addAttribute("contactmessage", contactMessage);
        return "contact";
    }

    @PostMapping({"/contact"})
    public String saveContactMessage(Model model) {
        return "redirect:/home";
    }
}
