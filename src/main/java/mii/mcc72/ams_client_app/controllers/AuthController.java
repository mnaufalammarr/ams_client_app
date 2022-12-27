package mii.mcc72.ams_client_app.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping
    public String login() {
        return "auth/auth";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/penalty")
    public String penalty() {
        return "user/penalty";
    }
    @GetMapping("/submission")
    public String submission() {
        return "user/submission";
    }
}
