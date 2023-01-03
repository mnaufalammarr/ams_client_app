package mii.mcc72.ams_client_app.controller.api;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.Department;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;
import mii.mcc72.ams_client_app.services.FinanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
@AllArgsConstructor
public class RestFinanceController {

    private FinanceService financeService;

    @GetMapping("departments")
    public List<Department> getListDepartment(){
        return financeService.getAllDepartment();
    }

    @GetMapping("recent_review")
    public  List<Asset> getAllRecentAssetReview(){
        return financeService.getAllRecentAssetReview();
    }
}
