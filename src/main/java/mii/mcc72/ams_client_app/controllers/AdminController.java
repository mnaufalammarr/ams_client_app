//package mii.mcc72.ams_client_app.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//
//



////error jika diakses dari controller ini, css js tidak terbaca
//@Controller
//@RequestMapping("/admin")
//@AllArgsConstructor
//// @PreAuthorize("hasRole('ROLE_ADMIN')")
//public class AdminController {
//
//    @GetMapping("/dashboard")
//    public String dashboardAdmin() {
//        return "dashboard-admin";
//    }
//
//    @GetMapping("/penalty")
//    public String penaltyAdmin() {
//        return "admin/penalty";
//    }
//    
//    @GetMapping("/review-submission")
//    public String submissionAdmin() {
//        return "admin/review-submission";
//    }
//
//    @GetMapping("/rentreview")
//    public String rentReview() {
//        return "admin/rent-review";
//    }
//    
//    @GetMapping("/list-rent-asset")
//    public String listRentAsset() {
//        return "admin/list-rent-asset";
//    }
//
//    @GetMapping("/submissionform")
//    public String submissionFormAdmin() {
//        return "admin/submission_form";
//    }
//
//    @GetMapping("/reportform")
//    public String reportFormAdmin() {
//        return "admin/report_form";
//    }
//}
