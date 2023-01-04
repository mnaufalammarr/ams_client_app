package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.Department;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class FinanceService {
    private RestTemplate restTemplate;

    public ResponseData<Asset> reviewSubmissionRequest(int id, ReviewAssetDTO reviewAssetDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/asset/review_asset/" + id, HttpMethod.POST, new HttpEntity(reviewAssetDTO),
                new ParameterizedTypeReference<ResponseData<Asset>>() {
                }).getBody();
    }

    public List<Department> getAllDepartment() {
        return restTemplate.exchange("http://localhost:8088/api/v1/department", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Department>>() {
                }).getBody();
    }

    public Department getDepartmentById(int id) {
        return restTemplate.exchange("http://localhost:8088/api/v1/department" + "/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Department>() {
                }).getBody();
    }

    //create method get all asset
    public List<Asset> getAllRecentAssetReview() {
        return restTemplate.exchange("http://localhost:8088/api/v1/asset/recent_review", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Asset>>() {
                }).getBody();
    }
}
