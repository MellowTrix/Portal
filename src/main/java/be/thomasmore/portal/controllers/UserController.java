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

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
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
        user.setFreeTrialAvailable(true);
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
            return "redirect:/wardrobe";
        }
        User user = userFromDb.get();
        if (!displayname.isEmpty()) {
            if (userRepository.findBydisplayname(displayname).isPresent() && !user.getDisplayname().equals(displayname)) {
                return "redirect:/wardrobe/nameError";
            }
            user.setDisplayname(displayname);
            userRepository.save(user);
        }
        if (!email.isEmpty()) {
            if (userRepository.findByEmail(email).isPresent() && !user.getEmail().equals(email)) {
                model.addAttribute("emailError", "The chosen email is unavailable");
                return "redirect:/wardrobe/emailError";
            }
            user.setEmail(email);
            userRepository.save(user);
        }
        return "redirect:/wardrobe";
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

    @GetMapping("/subscribe")
    public String subscribe(Model model, Principal principal) {
        return "user/subscribe";
    }

    @GetMapping("/subscribe/{monthCount}")
    public String addSubscription(Model model, @PathVariable Integer monthCount, Principal principal) {
        Optional<User> userFromDb = userRepository.findByUsername(principal.getName());
        if (userFromDb.isEmpty()) {
            return "redirect:/login";
        }
        User user = userFromDb.get();
        if (monthCount == 1 ) {
            user.setSubscriptionEndDate(calculateSub(monthCount, user.getSubscriptionEndDate()));
            user.setMonthsSubscribed(user.getMonthsSubscribed() + monthCount);
        } else if (monthCount == 12) {
            user.setSubscriptionEndDate(calculateSub(monthCount, user.getSubscriptionEndDate()));
            user.setMonthsSubscribed(user.getMonthsSubscribed() + monthCount);
        } else if (monthCount == 36) {
            user.setSubscriptionEndDate(calculateSub(monthCount, user.getSubscriptionEndDate()));
            user.setMonthsSubscribed(user.getMonthsSubscribed() + monthCount);
        } else {
            return "redirect:/user/subscribe";
        }
        user.setRole("DESIGNER");
        userRepository.save(user);
        return "redirect:/home";
    }

    public LocalDate calculateSub(int months, LocalDate subEndDate) {
        if (subEndDate == null) {
            subEndDate = LocalDate.now().plusMonths(months);
        } else if (Period.between(subEndDate, LocalDate.now()).getDays() <= 0) {
            subEndDate = subEndDate.plusMonths(months);
        }
        return subEndDate;
    }

//    @PostMapping("/subscribe")
//    public String subscribe(Model model, @ModelAttribute("user") User user, Principal principal) {
//        if (principal != null) {
//            return "redirect:/home";
//        }
//        /*Boolean sub = user.getSubscribed();
//        user.setSubscribed(sub);*/
//        return "user/subscribe";
//    }*/
}
