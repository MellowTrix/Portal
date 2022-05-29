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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        if (userFromDb.isPresent()){
            User user = userFromDb.get();
            model.addAttribute("ownedItems", itemRepository.findAllByOwner(user));
        }
        logger.info("ItemNew");
        model.addAttribute("posts", socialHubRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("socialPost", new SocialPost());
        model.addAttribute("login", loginName);
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

    @GetMapping("/hub/myPosts")
    public String HubMyPosts(Model model, Principal principal){
        final String loginName = (principal != null) ? principal.getName() : "";
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        if (userFromDb.isPresent()){
            User user = userFromDb.get();
            model.addAttribute("ownedPosts", socialHubRepository.findAllByOwner(user));
        }
        return "myPosts";
    }


    @ModelAttribute("editSocialPost")
    public SocialPost findPost(@PathVariable(required = false) Integer id) {
        logger.info("findMap " + id);
        if (id == null) return new SocialPost();

        Optional<SocialPost> optionalPost = socialHubRepository.findById(id);
        //noinspection OptionalIsPresent
        if (optionalPost.isPresent())
            return optionalPost.get();
        return null;
    }

    @GetMapping({"/hub/edit/{id}"})
    public String SocialEdit(Model model, @PathVariable(required = false) Integer id, Principal principal) {
        logger.info(String.format(" -- id=%d", id));
        final String loginName = (principal != null) ? principal.getName() : "";
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        model.addAttribute("login", loginName);
        SocialPost sp =  socialHubRepository.findById(id).get();
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            model.addAttribute("ownedItems", itemRepository.findAllByOwner(user));
            if (sp.getOwner().getId() != user.getId()) return "redirect:/error";
        }
        return "socialEdit";
    }

    @PostMapping("/hub/edit/{id}")
    public String SocialEditPost(Model model, @PathVariable Integer id, @ModelAttribute SocialPost editSocialPost){
        logger.info(String.format(" -- id=%d" , id));
        Optional<SocialPost> postFromDb = socialHubRepository.findById(id);
        if (postFromDb.isEmpty()) {
            return "redirect:/hub";
        }
        SocialPost socialPost = postFromDb.get();
        socialPost.setSubject(editSocialPost.getSubject());
        socialPost.setMessage(editSocialPost.getMessage());
        socialPost.setItem(editSocialPost.getItem());
        socialHubRepository.save(socialPost);
        return "redirect:/hub/myPosts";
    }

    @GetMapping({"/hub/delete/{id}"})
    public String removePost(@PathVariable(required = false) Integer id, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "";
        Optional<User> userFromDb = userRepository.findByUsername(loginName);
        SocialPost sp =  socialHubRepository.findById(id).get();
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            logger.info(String.format("postOwnerID",sp.getOwner().getId()));
            logger.info(String.format("userID --",user.getId()));
            if (sp.getOwner().getId() != user.getId()) return "redirect:/error";
        }
        socialHubRepository.delete(socialHubRepository.findById(id).get());
        return "redirect:/hub/myPosts";
    }
}
