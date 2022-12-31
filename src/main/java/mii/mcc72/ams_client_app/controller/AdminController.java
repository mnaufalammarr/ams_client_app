package mii.mcc72.ams_client_app.controller;
import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.services.AdminSubmissionService;
import mii.mcc72.ams_client_app.services.CategoryService;
import mii.mcc72.ams_client_app.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private AdminSubmissionService adminSubmissionService;
    private CategoryService categoryService;
    private EmployeeService employeeService;
    
    // Tes Admin
    @GetMapping("/dashboard-admin")
    public String dashboardAdmin() {
        return "dashboard-admin";
    }

    @GetMapping("/penalty")
    public String penaltyAdmin() {
        return "admin/penalty";
    }

    @GetMapping("/review-submission")
    public String submissionAdmin() {
        return "admin/review-submission";
    }

    @GetMapping("/rent-review")
    public String rentReview() {
        return "admin/rent-review";
    }

    @GetMapping("/list-rent-asset")
    public String listRentAsset() {
        return "admin/list-rent-asset";
    }

    @GetMapping("/submissionform")
    public String submissionFormAdmin() {
        return "admin/submission_form";
    }

    @GetMapping("/reportform")
    public String reportFormAdmin() {
        return "admin/report_form";
    }

    @GetMapping("/create")
    public String createSubmission(Asset asset, Model model) {
        model.addAttribute("employee", employeeService.getAll());
        model.addAttribute("category", categoryService.getAll());
        return "admin/submission_form";
    }

    @PostMapping
    public String createSubmission(Asset asset) {
        adminSubmissionService.createSubmission(asset);
        return "redirect:/admin";
    }

}