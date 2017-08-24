package com.cherrypicker.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by henrylian on 8/24/17.
 */
@RestController
public class HomeController {
    @RequestMapping("/index.html")
    public String index(HttpServletRequest request){

        return "hello, you are from " + request.getRemoteAddr();
    }
}
