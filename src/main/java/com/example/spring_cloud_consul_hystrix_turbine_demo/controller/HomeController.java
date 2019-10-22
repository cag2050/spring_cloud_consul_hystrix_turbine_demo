package com.example.spring_cloud_consul_hystrix_turbine_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    String home() {
        return "首页";
    }
}
