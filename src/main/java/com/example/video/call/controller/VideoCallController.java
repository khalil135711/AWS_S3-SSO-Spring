package com.example.video.call.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoCallController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
