package mii.mcc72.ams_client_app.controller;

import mii.mcc72.ams_client_app.models.User;
import mii.mcc72.ams_client_app.models.dto.RegistrationDTO;
import mii.mcc72.ams_client_app.models.dto.SubmissionDTO;
import mii.mcc72.ams_client_app.services.AdminService;
import mii.mcc72.ams_client_app.services.CategoryService;
import mii.mcc72.ams_client_app.services.EmployeeService;
import mii.mcc72.ams_client_app.services.FinanceService;
import mii.mcc72.ams_client_app.services.RegistrationService;
import mii.mcc72.ams_client_app.util.ExcelHelper;
import mii.mcc72.ams_client_app.util.FileUploadUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import mii.mcc72.ams_client_app.models.dto.RegistrationDTO;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private CategoryService categoryService;
    private EmployeeService employeeService;
    private RegistrationService registrationService;
    private FinanceService financeService;
    private AdminService adminService;

    @GetMapping("/submission")
    public String submission(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "submission");
        return "admin/submission";
    }

    @GetMapping("/penSubmission")
    public String PenSubmission(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "penSubmission");
        return "admin/pen_submission";
    }

    @GetMapping("/revSubmission")
    public String RevSubmission(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "revSubmission");
        return "admin/rev_submission";
    }

    @GetMapping("/submissionform")
    public String SubmissionForm(SubmissionDTO submissionDTO, Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "submission");
        model.addAttribute("categories", categoryService.getAll());
        return "admin/submission_form";
    }

    @PostMapping("/submissionAsset")
    public RedirectView submissionAsset(SubmissionDTO submissionDTO, Authentication authentication,
            @RequestParam("file") MultipartFile multipartFile) throws IOException {

        String fileName = UUID.randomUUID().toString().substring(0, 3) + "_"
                + StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "src/main/resources/static/img/" + authentication.getName();
        submissionDTO.setImage(authentication.getName() + "/" + fileName);
        employeeService.createSubmissionRequest(submissionDTO);
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/admin/submission", true);
    }

    @PostMapping("/uploadExcelFinance")
    public RedirectView uploadExcelFinance(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        if (ExcelHelper.hasExcelFormat(multipartFile)) {
            List<User> users = ExcelHelper.excelToUsers(multipartFile.getInputStream());
            System.out.println("Output Excel : " + users);
            adminService.registerFinanceFromExcel(users);
            System.out.println("Upload Berhasil");
        }
        return new RedirectView("/admin/register-finance", true);
    }

    @GetMapping("/available")
    public String available(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "available");
        return "admin/available";
    }

    // RENT
    @GetMapping("/penRent")
    public String penRent(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "penRent");
        return "admin/pen_rent";
    }

    @GetMapping("/revRent")
    public String revRent(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "revRent");
        return "admin/rev_rent";
    }

    @GetMapping("/repRent")
    public String repRent(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "repRent");
        return "admin/rep_rent";
    }

    @GetMapping("/doneRent")
    public String doneRent(Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "doneRent");
        return "admin/done_rent";
    }

    // finance
    @GetMapping("/register-finance")

    public String registerAccountFinanceView(RegistrationDTO registrationDTO, Authentication authentication,
            Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "regFinance");
        return "admin/register-finance";
    }

    @PostMapping("/register-finance")
    public String registerAccountFinance(RegistrationDTO registrationDTO) {
        registrationService.registrationFinanceAccount(registrationDTO);
        return "redirect:/admin/list-user";

    }

    // employee
    @GetMapping("/register-emp")
    public String registerAccountEmployeeView(RegistrationDTO registrationDTO, Authentication authentication,
            Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "regEmp");
        model.addAttribute("departments", financeService.getAllDepartment());
        return "admin/register-emp";
    }

    @PostMapping("/register-emp")
    public String registerAccountEmployee(RegistrationDTO registrationDTO) {
        registrationService.registrationEmployeeAccount(registrationDTO);
        return "redirect:/admin/list-user";
    }

    // list user
    @GetMapping("/list-user")
    public String listUser(RegistrationDTO registrationDTO, Authentication authentication, Model model) {
        model.addAttribute("user", authentication.getName());
        model.addAttribute("isActive", "listUser");
        return "admin/list-user";
    }

}
