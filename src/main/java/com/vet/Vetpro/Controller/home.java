package com.vet.Vetpro.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class home {

    @GetMapping("/")
    public String index(Model model) {
        log.info("estas en el home");
        return"home";
    }
}
