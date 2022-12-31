package mii.mcc72.ams_client_app.controller;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.RentDTO;
import mii.mcc72.ams_client_app.services.EmployeeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/penalty")
    public String penalty(Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "penalty");
        return "user/penalty";
    }
    @GetMapping("/penalty/{id}")
    public String penalty(@PathVariable int id , Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "penalty");
        model.addAttribute("id",id);
        return "user/detail_penalty";
    }
    @GetMapping("/submission")
    public String submission(Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "submission");
        return "user/submission";
    }
    @GetMapping("/available")
    public String available(Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "available");
        return "user/available";
    }
    @GetMapping("/rent")
    public String rent(Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "rent");
        return "user/rent";
    }
    @GetMapping("/submissionform")
    public String submissionform(Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "submission");
        return "user/submission_form";
    }
    @GetMapping("/rentform/{id}")
    public String rentform(@PathVariable int id , RentDTO rentDTO , Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "rent");
        model.addAttribute("asset",employeeService.getAssetById(id));
        System.out.println(employeeService.getAssetById(id));
        return "user/rent_form";
    }

    @PostMapping("/rentAsset")
    public String rentAsset(RentDTO rentDTO) {
        System.out.println(rentDTO);
        rentDTO.setEmployeeId(0);
        employeeService.createRentRequest(rentDTO);
        return "redirect:/v1/rent";
    }
//
//    // Tes Admin
//    @GetMapping("/dashboard-admin")
//    public String dashboardAdmin() {
//        return "dashboard-admin";
//    }
//
//    @GetMapping("/penalty-admin")
//    public String penaltyAdmin() {
//        return "admin/penalty";
//    }
//
//    @GetMapping("/review-submission-admin")
//    public String submissionAdmin() {
//        return "admin/review-submission";
//    }
//
//    @GetMapping("/rentreview-admin")
//    public String rentReview() {
//        return "admin/rent-review";
//    }
//
//    @GetMapping("/list-rent-asset")
//    public String listRentAsset() {
//        return "admin/list-rent-asset";
//    }
//
//    @GetMapping("/submissionform-admin")
//    public String submissionFormAdmin() {
//        return "admin/submission_form";
//    }
//
//    @GetMapping("/reportform-admin")
//    public String reportFormAdmin() {
//        return "admin/report_form";
//    }




}
