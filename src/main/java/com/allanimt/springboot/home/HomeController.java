package com.allanimt.springboot.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Only for Testing XD
@RestController
public class HomeController {
    @RequestMapping(value = "/")
    public String helloWorldMethod() {
        return "Hello World :D";
    }

    @GetMapping(value = "/{name}")
    public String helloWithName(@PathVariable String name) {
        return String.format("Welcome, your name is: %s", name);
    }
}
