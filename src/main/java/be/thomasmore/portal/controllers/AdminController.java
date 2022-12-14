package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.ContactMessage;
import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ContactMessageRepository;
import be.thomasmore.portal.repositories.ItemRepository;
import be.thomasmore.portal.repositories.UserRepository;
import be.thomasmore.portal.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactMessageRepository contactMessageRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    public EmailService emailService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Iterable<User> users = userRepository.findAll();
        Iterable<ContactMessage> contactMessages = contactMessageRepository.findAll();
        List<Item> items = itemRepository.findAll();
        int userCount = 0;
        int subscriberCount = 0;
        for (User user : users) {
            userCount++;
            if (user.getRole().equals("DESIGNER")) {
                subscriberCount++;
            }
        }
        model.addAttribute("users", users);
        model.addAttribute("contactMessages", contactMessages);
        model.addAttribute("userCount", userCount);
        model.addAttribute("subscriberCount", subscriberCount);
        model.addAttribute("itemCount", items.size());
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
        if (contactMessageRepository.findById(message.getId()).isEmpty()) {
            return "redirect:/admin/dashboard";
        }
        emailService.sendSimpleMessage(message.getEmail(), "RE: " + message.getSubject(), replyMessage);
        contactMessageRepository.delete(contactMessageRepository.findById(message.getId()).get());
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam String username, @RequestParam(required = false) Integer daysCount, @RequestParam(required = false) String newUsername,
                           @RequestParam(required = false) String newDisplayname, @RequestParam(required = false) String newEmail) {
        Optional<User> userFromDb = userRepository.findByUsername(username);
        if (userFromDb.isEmpty()) {
            return "redirect:/admin/dashboard";
        }
        User user = userFromDb.get();
        if (daysCount != null) {
            user.setSubscriptionEndDate(calculateSub(daysCount, user.getSubscriptionEndDate()));
            if (!user.getRole().equals("ADMIN")) {
                user.setRole("DESIGNER");
            }
        }
        if (newUsername != null && !newUsername.equals("")) {
            if (userRepository.findByUsername(newUsername).isPresent()) {
                return "redirect:/admin/dashboard";
            }
            user.setUsername(newUsername);
        }
        if (newDisplayname != null && !newDisplayname.equals("")) {
            if (userRepository.findBydisplayname(newDisplayname).isPresent()) {
                return "redirect:/admin/dashboard";
            }
            user.setDisplayname(newDisplayname);
        }
        if (newEmail != null && !newEmail.equals("")) {
            if (userRepository.findByEmail(newEmail).isPresent()) {
                return "redirect:/admin/dashboard";
            }
            user.setEmail(newEmail);
        }
        userRepository.save(user);
        return "redirect:/admin/dashboard";
    }

    public LocalDate calculateSub(int days, LocalDate subEndDate) {
        if (subEndDate == null || Period.between(subEndDate, LocalDate.now()).getDays() > 0) {
            subEndDate = LocalDate.now().plusDays(days);
        } else if (Period.between(subEndDate, LocalDate.now()).getDays() <= 0) {
            subEndDate = subEndDate.plusDays(days);
        }
        return subEndDate;
    }
}
