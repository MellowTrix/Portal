package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ItemRepository;
import be.thomasmore.portal.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class WardrobeController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping({"/wardrobe", "/wardrobe/{error}"})
    public String home(Model model, @PathVariable(required = false) String error, @RequestParam(required = false) String search, @RequestParam(required = false) List<String> color, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
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
        List<Item> ownedItemList = itemRepository.findFilterForUser(user, search, color);


        model.addAttribute("loginName", username);
        model.addAttribute("user", user);
        model.addAttribute("ownedItems", ownedItemList);
        model.addAttribute("ownedItemsCount", ownedItemList.size());
        model.addAttribute("search", search);
        model.addAttribute("color", color);
        return "wardrobe";
    }

    @GetMapping({"/item", "/item/{id}"})
    public String itemDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "item";

        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        }

        return "item";
    }

//    @GetMapping({"/item/share/{id}"})
//    public String share(Model model, @PathVariable(required = false) Integer id) {
//        Item item = itemRepository.findById(id).get();
//        Post post = new Post;
//
//        return "redirect:/hub/";
//    }

    @GetMapping({"/item/delete/{id}"})
    public String delete(Model model, @PathVariable(required = false) Integer id) {
        itemRepository.delete(itemRepository.findById(id).get());
        return "redirect:/wardrobe/";
    }
}

