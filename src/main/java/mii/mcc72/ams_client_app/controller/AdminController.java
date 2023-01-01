package mii.mcc72.ams_client_app.controller;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.dto.SubmissionDTO;
import mii.mcc72.ams_client_app.services.CategoryService;
import mii.mcc72.ams_client_app.services.EmployeeService;
import mii.mcc72.ams_client_app.util.FileUploadUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.UUID;
import mii.mcc72.ams_client_app.services.AdminService;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private EmployeeService employeeService;
    private AdminService adminService;

    private CategoryService categoryService;

       @PostMapping("/submissionAsset")
        public RedirectView submissionAsset(SubmissionDTO submissionDTO, Authentication authentication, @RequestParam("file") MultipartFile multipartFile) throws IOException {

       String fileName = UUID.randomUUID().toString().substring(0, 3) + "_" + submissionDTO.getName() + "_" + StringUtils.cleanPath(multipartFile.getOriginalFilename());
       String uploadDir = "src/main/resources/static/img/" + authentication.getName();
       submissionDTO.setImage(authentication.getName() + "/" + fileName);
       employeeService.createSubmissionRequest(submissionDTO);
       FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
       return new RedirectView("/admin/submission-review", true);
   }

    // Tes Admin
    @GetMapping("/dashboard-admin")
    public String dashboardAdmin() {
        return "dashboard-admin";
    }

    @GetMapping("/rent-review")
    public String rentReview() {
        return "admin/rent-review";
    }

    @GetMapping("/penalty")
    public String penaltyAdmin() {
        return "admin/penalty";
    }

    @GetMapping("/submission-review")
    public String submissionReview() {
        return "admin/submission-review";
    }

    @GetMapping("/list-rent-asset")
    public String listRentAsset() {
        return "admin/list-rent-asset";
    }

    @GetMapping("/submission-form")
    public String submissionForm() {
        return "admin/submission-form";
    }

    @GetMapping("/reportform")
    public String reportForm() {
        return "admin/report-form";
    }
    
    //----------------------------------

//    @GetMapping("/create-submission")
//    public String createSubmission(Asset asset, Model model) {
//        model.addAttribute("employee", employeeService.getAll());
//        model.addAttribute("category", categoryService.getAll());
//        return "admin/submission_form";
//    }

    //-----
//    @GetMapping("/penalty")
//    public String penalty(Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "penalty");
//        return "user/penalty";
//    }
//
//    @GetMapping("/penalty/{id}")
//    public String penalty(@PathVariable int id, Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "penalty");
//        model.addAttribute("id", id);
//        return "user/detail_penalty";
//    }
//
//    @GetMapping("/submission")
//    public String submission(Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "submission");
//        return "user/submission";
//    }
//
//    @GetMapping("/available")
//    public String available(Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "available");
//        return "user/available";
//    }
//
//    @GetMapping("/rent")
//    public String rent(Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "rent");
//        return "user/rent";
//    }
//
//    @GetMapping("/submissionform")
//    public String submissionform(SubmissionDTO submissionDTO, Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "submission");
//        model.addAttribute("categories", categoryService.getAll());
//        return "user/submission_form";
//    }
//
//    @GetMapping("/rentform/{id}")
//    public String rentform(@PathVariable int id, RentDTO rentDTO, Authentication authentication, Model model) {
//        model.addAttribute("user", authentication.getName());
//        model.addAttribute("isActive", "rent");
//        model.addAttribute("asset", employeeService.getAssetById(id));
//        System.out.println(employeeService.getAssetById(id));
//        return "user/rent_form";
//    }
//
//    @PostMapping("/rentAsset")
//    public String rentAsset(RentDTO rentDTO) {
//        System.out.println(rentDTO);
//        rentDTO.setEmployeeId(0);
//        employeeService.createRentRequest(rentDTO);
//        return "redirect:/v1/rent";
//    }
//

    
    
    //-------------------------------
    
    
    
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
