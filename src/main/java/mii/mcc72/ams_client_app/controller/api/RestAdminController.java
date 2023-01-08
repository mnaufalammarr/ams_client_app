package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.Report;
import mii.mcc72.ams_client_app.models.dto.ReportDTO;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;
import mii.mcc72.ams_client_app.models.dto.ReviewRentDTO;
import mii.mcc72.ams_client_app.services.AdminService;
import mii.mcc72.ams_client_app.services.DashboardService;
import mii.mcc72.ams_client_app.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import mii.mcc72.ams_client_app.models.User;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class RestAdminController {

    private DashboardService dashboardService;
    private AdminService adminService;

    @GetMapping("/submission")
    public List<Asset> getAdmSubmission() {
        return dashboardService.getAdmSubmission();
    }
    @GetMapping("/penSubmission")
    public List<Asset> getAdmReqSubmission() {
        return dashboardService.getAdmReqSubmission();
    }
    @GetMapping("/revSubmission")
    public List<Asset> getAdmListSubmission() {
        return dashboardService.getAdmListSubmission();
    }

    @GetMapping("/getQty/{id}")
    public Asset getQty(@PathVariable("id") int id) {
        return adminService.getQty(id);
    }
    @GetMapping("/available")
    public List<Asset> getAvailable() {
        return dashboardService.getAvailable();
    }
//    Rent
    @GetMapping("/penRent")
    public List<History> getPenRent() {
        return dashboardService.getAdmReqRent();
    }
    @GetMapping("/revRent")
    public List<History> getRevRent() {
        return dashboardService.getAdmRent();
    }
    @GetMapping("/repRent")
    public List<Object> getRepRent() {
        return dashboardService.getAdmReport();
    }
    @GetMapping("/doneRent")
    public List<History> getDoneRent() {
        return dashboardService.getAdmReturn();
    }

    @PutMapping("/reviewReqRent/{id}")
    public ResponseData<History> reviewReqRent(@PathVariable("id") int id, @RequestBody ReviewRentDTO reviewRentDto) {

        return adminService.reviewReqRent(id, reviewRentDto);
    }
    @PutMapping("/report/{id}")
    public ResponseData<Report> reportRent(@PathVariable("id") int id, @RequestBody ReportDTO reportDTO) {

        return adminService.reportRent(id, reportDTO);
    }

    //list user
    @GetMapping("/list-user")
    public List<User>getAllUser(){
        return dashboardService.getAllUser();
    }

}
