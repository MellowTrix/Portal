package be.thomasmore.portal.controllers;

import be.thomasmore.portal.models.Item;
import be.thomasmore.portal.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping({"/webshop"})
    public String itemList(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "webshop";
    }

    @GetMapping({"/itemDetails","/itemDetails/{id}"})
    public String itemDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "itemDetails";

        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        }

        return "carDetails";
    }

//    @GetMapping({"/webshop/filter"})
//    public String carFilters(Model model, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) List<String> fuel){
//        List<Item> items;
//        items = ItemRepository.findFilter(minPrice, maxPrice, fuel);
//        model.addAttribute("cars", items);
//
//        return "webshop";
//    }

}
