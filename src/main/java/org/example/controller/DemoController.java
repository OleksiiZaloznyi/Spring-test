package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
public class DemoController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message ", "Hello Spring!");
        return "index";
    }

    @ResponseBody
    @GetMapping("/time")
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }
}
