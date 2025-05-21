package com.ssg.gallery.common.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MainController {

    @GetMapping("/api/greeting")
    public String greeting(){
        return "Hello World!";
    }

}
