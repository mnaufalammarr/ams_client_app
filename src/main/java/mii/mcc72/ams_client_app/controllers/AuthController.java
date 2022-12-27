package mii.mcc72.ams_client_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping
    public String login() {
        return "auth/auth";
    }
}
