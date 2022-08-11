package com.sentiment.com.sentiment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:56
 */
@RestController
@RequestMapping("/article")
public class IndexController {

    @GetMapping("/test")
    public String test(){
        return "string";
    }
}
