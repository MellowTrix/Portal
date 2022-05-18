package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "";

        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            if (Period.between(LocalDate.now(), user.getSubscriptionEndDate()).getDays() < 0) {
                user.setRole("USER");
                user.setSubscriptionEndDate(null);
                userRepository.save(user);
            }
        }
        model.addAttribute("loginName", loginName);
        return "home";
    }

    @GetMapping({"/studio"})
    public String hub(Model model) {
        return "studio";
    }

    @GetMapping({"/aboutUs"})
    public String aboutUs(Model model) {
        return "aboutUs";
    }

    @GetMapping({"/login"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping({"/logout"})
    public String logout(Model model) {
        return "logout";
    }

}
