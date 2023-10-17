package com.mycompany.applicationone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("C")
public class Controller {

    @GetMapping("/Controller")
    public String welcome(){
        return "Bonjour";
    }
}
