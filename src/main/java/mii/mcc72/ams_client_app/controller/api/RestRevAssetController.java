package mii.mcc72.ams_client_app.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;
import mii.mcc72.ams_client_app.services.FinanceService;

@RestController
@RequestMapping("/api/review_asset")
@AllArgsConstructor
public class RestRevAssetController {
    private FinanceService financeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseData<Asset> reviewSubmissionRequest(@PathVariable int id, @RequestBody ReviewAssetDTO reviewAssetDTO){
        return financeService.reviewSubmissionRequest(id, reviewAssetDTO);
    }
}
