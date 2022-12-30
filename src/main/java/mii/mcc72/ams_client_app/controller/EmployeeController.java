package mii.mcc72.ams_client_app.controller;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.services.PenaltyService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
@AllArgsConstructor
public class EmployeeController {

    private PenaltyService penaltyService;

    @GetMapping("/penalty")
    public String penalty(Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        return "user/penalty";
    }
    @GetMapping("/penalty/{id}")
    public String penalty(@PathVariable int id , Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("id",id);
        return "user/detail_penalty";
    }
    @GetMapping("/submission")
    public String submission() {
        return "user/submission";
    }
    @GetMapping("/available")
    public String available() {
        return "user/available";
    }
    @GetMapping("/rent")
    public String rent() {
        return "user/rent";
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

    @GetMapping("/review-submission-admin")
    public String submissionAdmin() {
        return "admin/review-submission";
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
