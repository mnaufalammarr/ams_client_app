package mii.mcc72.ams_client_app.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//
//


import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.dto.LoginDTO;
import mii.mcc72.ams_client_app.models.dto.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
//// @PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    @GetMapping("/register-emp")
    public String registerAccountEmployeeView(RegistrationDTO registrationDTO) {
        return "admin/register-emp";
    }

    //belum tambah admin service
//    @PostMapping("/register-emp")
//    public String registerAccountEmployee(LoginDTO loginRequest) {
//        if (!adminService.login(loginRequest)) {
//            return "redirect:/login?error=true";
//        }
//        return "redirect:/dashboard";
//    }

    @GetMapping("/register-finance")
    public String registerAccountFinance(RegistrationDTO registrationDTO) {
        return "admin/register-finance";
    }

    //belum tambah admin service
//    @PostMapping("/register-emp")
//    public String registerAccountEmployee(LoginDTO loginRequest) {
//        if (!adminService.login(loginRequest)) {
//            return "redirect:/login?error=true";
//        }
//        return "redirect:/dashboard";
//    }
}
