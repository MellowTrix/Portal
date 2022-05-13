package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.repositories.ItemRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping({"/webshop"})
    public String carFilters(Model model, @RequestParam(required = false) String search, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) List<String> color){
        List<Item> items;
        items = itemRepository.findFilter(search, minPrice, maxPrice, color);
        if (minPrice== null && maxPrice == null) {
            minPrice = 0.0;
            maxPrice = getHighestPrice();
        }
        model.addAttribute("items", items);
        model.addAttribute("search", search);
        model.addAttribute("min", minPrice);
        model.addAttribute("max", maxPrice);
        model.addAttribute("highestPrice", getHighestPrice());
        model.addAttribute("color", color);

        return "webshop";
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
