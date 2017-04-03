package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ttomaka on 22.03.2017.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Server ok!";
    }

}
