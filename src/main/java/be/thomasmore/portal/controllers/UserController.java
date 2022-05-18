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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.AuthenticationException;
import java.security.Principal;
import java.util.Locale;
import java.util.Optional;

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
        if (user.getUsername().equals("") || userRepository.findByUsername(user.getUsername().toLowerCase(Locale.ROOT)).isPresent()) {
            model.addAttribute("nameError", "The chosen username is unavailable");
            return "user/register";
        }
        if (user.getEmail().equals("") || userRepository.findByEmail(user.getEmail().toLowerCase(Locale.ROOT)).isPresent()) {
            model.addAttribute("emailError", "The chosen email is unavailable");
            return "user/register";
        }
        String pass = user.getPassword();
        user.setUsername(user.getUsername());
        user.setDisplayname(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setDesignerApplication(user.getDesignerApplication());
        userRepository.save(user);
        autologin(user.getUsername(), pass);
        return "redirect:/home";
    }

    @PostMapping("/updateProfile/{loginName}")
    public String updateProfile(Model model, Principal principal, @PathVariable(required = true) String loginName, @RequestParam(required = false) String displayname,
                                @RequestParam(required = false) String email) {
        if (principal == null) {
            return "redirect:/home";
        }
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        if (userFromDb.isEmpty()) {
            return "redirect:/hub";
        }
        User user = userFromDb.get();
        if (!displayname.isEmpty()) {
            logger.info(displayname);
            if (userRepository.findBydisplayname(displayname).isPresent()) {
                return "redirect:/hub/nameError";
            }
            user.setDisplayname(displayname);
            userRepository.save(user);
        }
        if (!email.isEmpty()) {
            if (userRepository.findByEmail(email).isPresent()) {
                model.addAttribute("emailError", "The chosen email is unavailable");
                return "redirect:/hub/emailError";
            }
            user.setEmail(email);
            userRepository.save(user);
        }
        return "redirect:/hub";
    }

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
