package mii.mcc72.ams_client_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;


//error jika diakses dari controller ini, css js tidak terbaca
@Controller
@RequestMapping("/finance")
@AllArgsConstructor
// @PreAuthorize("hasRole('ROLE_FINANCE')")
public class FinanceController {

    @GetMapping("/dashboard")
    public String dashboardAdmin() {
        return "dashboard-finance";
    }
}