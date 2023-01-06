package com.vet.Vetpro.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class IndexController {


    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
}
