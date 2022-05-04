package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.AuthenticationException;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/register")
    public String register(Model model, Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute("user") User user, Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        if (user.getUsername().equals("") || userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "redirect:/user/register";
        }
        String pass = user.getPassword();
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setDesignerApplication(user.getDesignerApplication());
        userRepository.save(user);
        autologin(user.getUsername(), pass);
        return "redirect:/home";
    }

    //TODO Fix autologin
    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);

        try {
            Authentication auth = authenticationManager.authenticate(token);

            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
