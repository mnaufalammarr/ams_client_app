package mii.mcc72.ams_client_app.controller;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.dto.LoginDTO;
import mii.mcc72.ams_client_app.services.LoginService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@AllArgsConstructor
public class AuthController {

    private LoginService loginService;

    @GetMapping("/login")
    public String loginView(LoginDTO loginRequest, Authentication auth) {
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return "auth/login";
        }
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String login(LoginDTO loginRequest) {
        if (!loginService.login(loginRequest)) {
            return "redirect:/login?error=true";
        }
        return "redirect:/dashboard";
    }

    // @GetMapping("/dashboard")
    // public String dashboard(Authentication authentication , Model model) {
    //     model.addAttribute("user",authentication.getName());

    //     return "dashboard";
    // }

    //tes ke dashboard-admin
    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());

        return "dashboard-admin";
    }
    

}