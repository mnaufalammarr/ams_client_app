package mii.mcc72.ams_client_app.controller;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.Category;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.RentDTO;
import mii.mcc72.ams_client_app.models.dto.SubmissionDTO;
import mii.mcc72.ams_client_app.services.CategoryService;
import mii.mcc72.ams_client_app.services.EmployeeService;
import mii.mcc72.ams_client_app.util.FileUploadUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
@PreAuthorize("hasAnyRole('ADMIN','FINANCE','EMPLOYEE')")
@RequestMapping("/v1")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    private CategoryService categoryService;

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
    public String submissionform(SubmissionDTO submissionDTO, Authentication authentication, Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "submission");
        model.addAttribute("categories", categoryService.getAll());
        return "user/submission_form";
    }
    @GetMapping("/rentform/{id}")
    public String rentform(@PathVariable int id , RentDTO rentDTO , Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "rent");
        model.addAttribute("image", "/img/"+employeeService.getAssetById(id).getImage());
        model.addAttribute("asset",employeeService.getAssetById(id));
        return "user/rent_form";
    }
    @GetMapping("/detSub/{id}")
    public String detSub(@PathVariable int id , Authentication authentication,Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "rent");
        model.addAttribute("image", "/img/"+employeeService.getAssetById(id).getImage());
        model.addAttribute("asset",employeeService.getAssetById(id));
        model.addAttribute("format_price", changeFormatPriceToRupiah(employeeService.getAssetById(id).getPrice()));
        model.addAttribute("custom_status", customPendingAssetStatus(employeeService.getAssetById(id).getApprovedStatus()));
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String resultDate = formatter.format(employeeService.getAssetById(id).getDate());
        String year = employeeService.getAssetById(id).getDate().substring(0,4);
        String month = employeeService.getAssetById(id).getDate().substring(5,7);
        String date = employeeService.getAssetById(id).getDate().substring(8,10);
        model.addAttribute("custom_date", date + "-" + month + "-" + year);
        System.out.println(employeeService.getAssetById(id));
        return "user/detail_submission";
    }


    public String customPendingAssetStatus(String assetStatus){
        switch(assetStatus){
            case "PENDING_ADMIN" :
                return "Pending acc from admin";
            case "PENDING_FINANCE" :
                return "Pending acc from finance";
        }
        return "";
    }

    public String changeFormatPriceToRupiah(int price){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(price);
    }

    @PostMapping("/rentAsset")
    public String rentAsset(RentDTO rentDTO) {
        System.out.println(rentDTO);
        rentDTO.setEmployeeId(0);
        employeeService.createRentRequest(rentDTO);
        return "redirect:/v1/rent";
    }

    @PostMapping("/submissionAsset")
    public RedirectView submissionAsset(SubmissionDTO submissionDTO,Authentication authentication, @RequestParam("file") MultipartFile multipartFile) throws IOException {

        String fileName = UUID.randomUUID().toString().substring(0,3)+"_"+StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "src/main/resources/static/img/" +authentication.getName();
        submissionDTO.setImage(authentication.getName()+"/"+fileName);
        employeeService.createSubmissionRequest(submissionDTO);
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/v1/submission", true);
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
