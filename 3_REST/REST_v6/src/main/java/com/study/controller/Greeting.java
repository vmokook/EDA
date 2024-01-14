package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class Greeting {
    @GetMapping("/greeting")
    public Map<String, Object> greeting(){
        return Collections.singletonMap("message", "Application!");
    }
}
