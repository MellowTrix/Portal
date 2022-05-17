package be.thomasmore.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "";
        model.addAttribute("loginName", loginName);
        return "home";
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
