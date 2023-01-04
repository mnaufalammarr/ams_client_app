package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.services.DashboardService;
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
    @GetMapping("/available")
    public List<Asset> getAvailable() {
        return dashboardService.getAvailable();
    }
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
    @GetMapping("/rent")
    public List<History> getRent() {
        return dashboardService.getRent();
    }

    //list user
    @GetMapping("/list-user")
    public List<User>getAllUser(){
        return dashboardService.getAllUser();
    }

}
