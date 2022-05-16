package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.ContactMessage;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ContactMessageRepository;
import be.thomasmore.portal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ContactMessageRepository contactMessageRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Iterable<User> users = userRepository.findAll();
        Iterable<ContactMessage> contactMessages = contactMessageRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("contactMessages", contactMessages);
        return "admin/dashboard";
    }

}
