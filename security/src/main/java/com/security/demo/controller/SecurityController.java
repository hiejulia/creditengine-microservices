package com.security.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PM/")
public class SecurityController {
    //GET WITH AUTH
    @RequestMapping(method = RequestMethod.GET, value = "/secure/orders", produces = "application/json")
    public String getSecureOrders() {
        return "secure orders";
    }


    //GET WITHOUT AUTH

    @RequestMapping(method = RequestMethod.GET, value = "/unsecure/orders", produces = "application/json")
    public String getUnSecureOrders() {
        return "unsecure orders";
    }
}
