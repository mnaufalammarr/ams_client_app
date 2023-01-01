package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;
import mii.mcc72.ams_client_app.services.FinanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review_asset")
@AllArgsConstructor
public class RestRevAssetController {
    private FinanceService financeService;

    @PostMapping("/{id}")
    public ResponseData<Asset> reviewSubmissionRequest(@PathVariable int id, @RequestBody ReviewAssetDTO reviewAssetDTO){
        return financeService.reviewSubmissionRequest(id, reviewAssetDTO);
    }
}
