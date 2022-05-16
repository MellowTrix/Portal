package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.ContactMessage;
import be.thomasmore.portal.repositories.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @GetMapping({"/contact"})
    public String contact(Model model) {
        ContactMessage contactMessage = new ContactMessage();
        model.addAttribute("contactmessage", contactMessage);
        return "contact";
    }

    @PostMapping({"/contact"})
    public String saveContactMessage(Model model, @ModelAttribute("contactmessage") ContactMessage contactMessage) {
        contactMessage.setName(contactMessage.getName());
        contactMessage.setEmail(contactMessage.getEmail());
        contactMessage.setSubject(contactMessage.getSubject());
        contactMessage.setMessage(contactMessage.getMessage());
        contactMessageRepository.save(contactMessage);
        return "redirect:/home";
    }
}
