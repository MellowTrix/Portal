package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "";
        model.addAttribute("loginName", loginName);
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        if (userFromDb.isPresent()){
            User user = userFromDb.get();
            model.addAttribute("role",user.getRole());
        }
        return "home";
    }


    @GetMapping({"/aboutUs"})
    public String aboutUs(Model model, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "";
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        if (userFromDb.isPresent()){
            User user = userFromDb.get();
            model.addAttribute("role",user.getRole());
        }
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
