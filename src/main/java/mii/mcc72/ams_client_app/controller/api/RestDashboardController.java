package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
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
    
    //untuk employee
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

    //untuk admin
    @GetMapping("/available-admin")
    public List<Asset> getAvailableAdmin() {
        return dashboardService.getAvailableAdmin();
    }

    @GetMapping("/penalty-admin")
    public List<Report> getPenaltyAdmin() {
        return dashboardService.getPenaltyAdmin();
    }

    @GetMapping("/submission-admin")
    public List<Asset> getSubmissionAdmin() {
        return dashboardService.getSubmissionAdmin();
    }

    @GetMapping("/rent-admin")
    public List<History> getRentAdmin() {
        return dashboardService.getRentAdmin();
    }

}
