package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.services.DashboardService;
import mii.mcc72.ams_client_app.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestEmployeeController {

    private DashboardService dashboardService;
    private EmployeeService employeeService;
    @GetMapping("/penalty")
    public List<Object> getPenalty() {
        return employeeService.getPenalty();
    }
    @GetMapping("/penalty/{id}")
    public Object getById(@PathVariable int id) {
        return employeeService.getById(id);
    }
    @GetMapping("/available")
    public List<Asset> getAvailable() {
        return dashboardService.getAvailable();
    }
    @GetMapping("/submission")
    public List<Asset> getSubmission() {
        return dashboardService.getSubmission();
    }
    @GetMapping("/rent")
    public List<History> getRent() {
        return dashboardService.getRent();
    }
//
//    @GetMapping("/penalty")
//    public List<Report> getPenalty() {
//        return dashboardService.getPenalty();
//    }
//
//    @GetMapping("/submission")
//    public List<Asset> getSubmission() {
//        return dashboardService.getSubmission();
//    }
//
//    @GetMapping("/rent")
//    public List<History> getRent() {
//        return dashboardService.getRent();
//    }

}
