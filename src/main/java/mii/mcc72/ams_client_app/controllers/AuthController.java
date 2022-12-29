package mii.mcc72.ams_client_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/auth")
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
    @GetMapping("/available")
    public String available() {
        return "user/available";
    }
    @GetMapping("/submissionform")
    public String submissionform() {
        return "user/submission_form";
    }
    @GetMapping("/rentform")
    public String rentform() {
        return "user/rent_form";
    }
    @GetMapping("/detail_penalty")
    public String detail_penalty() {
        return "user/detail_penalty";
    }

    // Tes Admin
    @GetMapping("/dashboard-admin")
    public String dashboardAdmin() {
        return "dashboard-admin";
    }

    @GetMapping("/penalty-admin")
    public String penaltyAdmin() {
        return "admin/penalty";
    }
    @GetMapping("/submission-admin")
    public String submissionAdmin() {
        return "admin/submission";
    }
    @GetMapping("/rentreview-admin")
    public String rentReview() {
        return "admin/rent-review";
    }
    
    @GetMapping("/list-rent-asset")
    public String listRentAsset() {
        return "admin/list-rent-asset";
    }

    @GetMapping("/submissionform-admin")
    public String submissionFormAdmin() {
        return "admin/submission_form";
    }

    @GetMapping("/reportform-admin")
    public String reportFormAdmin() {
        return "admin/report_form";
    }

    


}
