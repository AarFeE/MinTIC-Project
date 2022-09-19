package com.proyecto.sistemagestion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericController {

    @GetMapping("/")
    public String MainPage(){
        return "mainPage";
    }

}