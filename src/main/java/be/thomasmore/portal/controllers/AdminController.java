package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.ContactMessage;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ContactMessageRepository;
import be.thomasmore.portal.repositories.UserRepository;
import be.thomasmore.portal.mail.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactMessageRepository contactMessageRepository;
    @Autowired
    public EmailService emailService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Iterable<User> users = userRepository.findAll();
        Iterable<ContactMessage> contactMessages = contactMessageRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("contactMessages", contactMessages);
        return "admin/dashboard";
    }

    @GetMapping("/contactdetails/{id}")
    public String contactdetails(Model model, @PathVariable Integer id) {
        Optional<ContactMessage> messageFromDb = contactMessageRepository.findById(id);
        if (messageFromDb.isPresent()) {
            ContactMessage message = messageFromDb.get();
            model.addAttribute("message", message);
        } else {
            return "redirect:/admin/dashboard";
        }
        return "admin/contactdetails";
    }

    @PostMapping("/replyEmail")
    public String replyEmail(@ModelAttribute("message") ContactMessage message, @RequestParam(required = false) String replyMessage) {
        logger.info("=============================");
        logger.info(message.getEmail());
        logger.info("=============================");
        logger.info(message.getSubject());
        logger.info("=============================");
        emailService.sendSimpleMessage(message.getEmail(), "RE: " + message.getSubject(), replyMessage);
        return "redirect:/home";
    }
}
