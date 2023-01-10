package com.dimicon.Dimicon_crypto_simulator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController implements WebMvcConfigurer {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView() {


        return "login";
    }

}
