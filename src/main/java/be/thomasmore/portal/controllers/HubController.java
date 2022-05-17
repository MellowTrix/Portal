package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ItemRepository;
import be.thomasmore.portal.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class HubController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping({"/hub", "/hub/{error}"})
    public String home(Model model, @PathVariable(required = false) String error, Principal principal) {
        if (principal == null) {
            return "redirect:/home";
        }
        if (error != null) {
            if (error.equals("nameError")) {
                model.addAttribute("nameError", "Chosen username is unavailable");
            } else if (error.equals("emailError")) {
                model.addAttribute("emailError", "Chosen email is unavailable");
            }
        }
        String username = principal.getName();
        Optional<User> userFromDb = userRepository.findByUsername(username);
        User user = userFromDb.get();
        List<Item> ownedItemList =  itemRepository.findAllByOwner(user);

        double inventoryValue = 0;
        for (Item i : ownedItemList) {
            inventoryValue += i.getPrice();
        }

        model.addAttribute("loginName", username);
        model.addAttribute("user", user);
        model.addAttribute("ownedItems", ownedItemList);
        model.addAttribute("ownedItemsCount", ownedItemList.size());
        model.addAttribute("inventoryValue", inventoryValue);
        model.addAttribute("role", user.getRole());
        return "hub";
    }
}
