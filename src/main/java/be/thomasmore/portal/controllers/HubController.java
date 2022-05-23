package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.models.SocialPost;
import be.thomasmore.portal.models.User;
import be.thomasmore.portal.repositories.ItemRepository;
import be.thomasmore.portal.repositories.SocialHubRepository;
import be.thomasmore.portal.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class HubController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SocialHubRepository socialHubRepository;

    final Logger logger = LoggerFactory.getLogger(DesignerController.class);

    @GetMapping("/hub")
    public String hub(Model model, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "";
        logger.info("ItemNew");
        model.addAttribute("login", loginName);
        model.addAttribute("posts", socialHubRepository.findAll());
        model.addAttribute("socialPost", new SocialPost());
        return "hub";
    }

    @PostMapping("/hub")
    public String HubNewPost(Model model,
                              @ModelAttribute("socialPost") SocialPost sp, Principal principal) {
        if (userRepository.findByUsername(principal.getName()).isEmpty()) {
            return "redirect:/home";
        }
        User user = userRepository.findByUsername(principal.getName()).get();
        logger.info("spNewPost -- new sp Subject=" + sp.getSubject());
        sp.setCreationDate(LocalDate.now());
        sp.setOwner(user);
        socialHubRepository.save(sp);

        return "redirect:/hub/";
    }
}
