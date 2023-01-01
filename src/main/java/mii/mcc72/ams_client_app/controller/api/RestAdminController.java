package mii.mcc72.ams_client_app.controller.api;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewRentDTO;
import mii.mcc72.ams_client_app.services.AdminService;
import mii.mcc72.ams_client_app.services.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestAdminController {
    
    private AdminService adminService;
    private DashboardService dashboardService;
    
    // @GetMapping("/getAllRentRequest")
    // public List<History> getAllRentRequest() {
    //     return adminService.getAllRentRequest();
    // }
    
    //used
    @GetMapping("/rent-review")
    public List<Object> rentReview(){
        return adminService.rentReview();
    }

    // @GetMapping("/getAllSubmissionRequest")
    // public List<Asset> getSubmission() {
    //     return adminService.getAllSubmissionRequest();
    // }

    //getAllSubmissionRequest-v2
//    @GetMapping("/getAllSubmissionRequest")
//    public List<Object> getAllSubmissionRequest() {
//       return adminService.getAllSubmissionRequest();
//   }
//    
    @GetMapping("/review_rent")
    @PostMapping("/{id}")
    public ResponseData<History> reviewRentRequest(@PathVariable int id, @RequestBody ReviewRentDTO reviewRentDTO){
        return adminService.reviewRentRequest(id, reviewRentDTO);
    }

//    @GetMapping("/pending_assets_finance")
//    public List<Object> getPendingAssetsFinance() {
//        return dashboardService.getPendingAssetsFinance();
//    }

   @GetMapping("/pending_assets_finance")
    public List<Object> getPendingAssetsFinance() {
        return adminService.getPendingAssetsFinance();
    }

}
