package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;
import mii.mcc72.ams_client_app.services.AdminService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestAdminController {

    private AdminService adminService;

    //submission review
    @GetMapping("/pending_assets_admin")
    public List<Object> getPendingAssetsAdmin() {
        return adminService.getPendingAssetsAdmin();
    }

    @PostMapping("/review_asset/{id}")
    public ResponseData<Asset> reviewSubmissionRequest(@PathVariable int id, @RequestBody ReviewAssetDTO reviewAssetDTO){
        return adminService.reviewSubmissionRequest(id, reviewAssetDTO);
    }
    //akhir submission review

    //rent review
    @GetMapping("/rent-review")
    public List<History> rentReviewAdmin() {
        return adminService.getRentReview();
    }
    //akhir rent review


}
