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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class DesignerController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    final Logger logger = LoggerFactory.getLogger(DesignerController.class);

    @GetMapping("/studio")
    public String studio(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> userFromDb = userRepository.findByUsername(username);
        User user = userFromDb.get();
        if (principal == null) {
            return "redirect:/home";
        }
        if (user.getRole().equals("USER")){
            return "redirect:/home";
        }

        logger.info(String.valueOf(user.getId()));
        final String loginName = (principal != null) ? principal.getName() : "";
        logger.info("ItemNew");
        model.addAttribute("role",user.getRole());
        model.addAttribute("login", loginName);
        model.addAttribute("item", new Item());
        return "studio";
    }

    @PostMapping("/studio")
    public String ItemNewPost(Model model,
                              @ModelAttribute("item") Item item, Principal principal) {
        if (userRepository.findByUsername(principal.getName()).isEmpty()) {
            return "redirect:/home";
        }
        User user = userRepository.findByUsername(principal.getName()).get();
        logger.info("mapNewPost -- new name=" + item.getName());
        item.setOwner(user);
        itemRepository.save(item);

        return "redirect:/hub/";
    }
}
