package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.Employee;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.Report;
import mii.mcc72.ams_client_app.services.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@AllArgsConstructor
public class RestDashboardController {

    private DashboardService dashboardService;

    @GetMapping("/available")
    public List<Asset> getAvailable() {
        return dashboardService.getAvailable();
    }

    @GetMapping("/penalty")
    public List<Report> getPenalty() {
        return dashboardService.getPenalty();
    }

    @GetMapping("/submission")
    public List<Asset> getSubmission() {
        return dashboardService.getSubmission();
    }

    @GetMapping("/rent")
    public List<History> getRent() {
        return dashboardService.getRent();
    }
//    ADMIN
    @GetMapping("/admSubmission")
    public List<Asset> getAdmSubmission() {
        return dashboardService.getAdmSubmission();
    }
    @GetMapping("/admReqSubmission")
    public List<Asset> getAdmReqSubmission() {
        return dashboardService.getAdmReqSubmission();
    }
    @GetMapping("/admListSubmission")
    public List<Asset> getAdmListSubmission() {
        return dashboardService.getAdmListSubmission();
    }
    @GetMapping("/admRent")
    public List<History> getAdmRent() {
        return dashboardService.getAdmRent();
    }
    @GetMapping("/admReqRent")
    public List<History> getAdmReqRent() {
        return dashboardService.getAdmReqRent();
    }
    @GetMapping("/admReport")
    public List<Report> getAdmReport() {
        return dashboardService.getAdmReport();
    }
    @GetMapping("/admReturn")
    public List<History> getAdmReturn() {
        return dashboardService.getAdmReturn();
    }
    @GetMapping("/admUser")
    public List<Employee> getAdmUser() {
        return dashboardService.getAdmUser();
    }

    @GetMapping("/pending_assets_finance")
    public List<Object> getPendingAssetsFinance() {
        return dashboardService.getPendingAssetsFinance();
    }
}
