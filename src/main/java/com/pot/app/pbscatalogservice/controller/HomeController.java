package com.pot.app.pbscatalogservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Идентифицирует класс, определяющий обработчики для конечных точек REST/HTTP.
public class HomeController {
//    private final PolarProperties properties;
//
//    public HomeController(PolarProperties properties) {
//        this.properties = properties;
//    }

    @GetMapping("/")
    public String getGreeting() {
        return "Welcome to the book catalog!";
    }


//    @GetMapping("/")//Обрабатывает запросы GET к корневой конечной точке.
//    public String getGreeting() {
//        return properties.getGreeting();
//    }
}

