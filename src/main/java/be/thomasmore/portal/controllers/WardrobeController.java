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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String home(Model model, @PathVariable(required = false) String error,  @RequestParam(required = false) String search, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) List<String> color,Principal principal) {
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
        List<Item> ownedItemList =  itemRepository.findFilterForUser(user, search, minPrice, maxPrice, color);

        double inventoryValue = 0;
        for (Item i : ownedItemList) {
            inventoryValue += i.getPrice();
        }

        model.addAttribute("loginName", username);
        model.addAttribute("user", user);
        model.addAttribute("ownedItems", ownedItemList);
        model.addAttribute("ownedItemsCount", ownedItemList.size());
        model.addAttribute("inventoryValue", inventoryValue);
        model.addAttribute("search", search);
        model.addAttribute("min", minPrice);
        model.addAttribute("max", maxPrice);
        model.addAttribute("highestPrice", getHighestPrice());
        model.addAttribute("color", color);
        return "wardrobe";
    }

    @GetMapping({"/item","/item/{id}"})
    public String itemDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "item";

        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        }

        return "item";
    }

    public double getHighestPrice() {
        Comparator<Item> itemPrice = Comparator.comparing(Item::getPrice);
        List<Item> higestItemPrice = itemRepository.findAll();
        higestItemPrice.sort(itemPrice);
        return higestItemPrice.get(higestItemPrice.size()-1).getPrice();

    }
}
