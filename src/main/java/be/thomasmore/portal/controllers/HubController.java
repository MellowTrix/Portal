package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ItemRepository;
import be.thomasmore.portal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class HubController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/hub"})
    public String home(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/home";
        }
        String username = principal.getName();
        Optional<User> userFromDb = userRepository.findByUsername(username);
        User user = userFromDb.get();
        List<Item> ownedItemList =  itemRepository.findAllByOwner(user);

        double inventoryValue = 0;
        for (Item i : ownedItemList) {
            inventoryValue += i.getPrice();
        }

        model.addAttribute("user", user);
        model.addAttribute("ownedItems", ownedItemList);
        model.addAttribute("ownedItemsCount", ownedItemList.size());
        model.addAttribute("inventoryValue", inventoryValue);
        return "hub";
    }
}
