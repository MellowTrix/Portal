package be.thomasmore.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @GetMapping("/webshop")
    public String itemList() {


        return "webshop";
    }

}
