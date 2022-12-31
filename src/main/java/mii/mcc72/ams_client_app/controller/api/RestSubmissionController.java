package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.services.SubmissionService;

@RestController
@RequestMapping("/api/submission")
@AllArgsConstructor
public class RestSubmissionController {

    private SubmissionService submissionService;
    
    @GetMapping
    public List<Asset> getSubmission() {
        return submissionService.getAll();
    }
    
    
//    @GetMapping("/{id}")
//    public Object getById(@PathVariable int id) {
//        return penaltyService.getById(id);
//    }
//    @GetMapping("/available")
//    public List<Asset> getAvailable() {
//        return dashboardService.getAvailable();
//    }
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
