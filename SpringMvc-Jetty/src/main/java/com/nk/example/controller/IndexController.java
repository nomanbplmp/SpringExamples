package com.nk.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return "Hello";
    }

}
