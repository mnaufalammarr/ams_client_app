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

}
