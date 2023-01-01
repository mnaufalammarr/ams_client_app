package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.RentDTO;
import mii.mcc72.ams_client_app.models.dto.SubmissionDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewAssetDTO;

@Service
@AllArgsConstructor
public class AdminService {

    private RestTemplate restTemplate;
    public List<Object> getPendingAssetsAdmin() {
        return restTemplate.exchange("http://localhost:8088/api/v1/admin/assets_pending_admin", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Object>>() {
                }).getBody();
    }
    
    public ResponseData<Asset> reviewSubmissionRequest(int id, ReviewAssetDTO reviewAssetDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/asset/review_asset/" + id, HttpMethod.POST, new HttpEntity(reviewAssetDTO),
                new ParameterizedTypeReference<ResponseData<Asset>>() {
                }).getBody();
    }

    public List<Object> rentReviewAdmin() {
        return restTemplate.exchange("http://localhost:8088/api/v1/history", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Object>>() {
                }).getBody();
    }

    public List<History> getRentReview() {
        return restTemplate.exchange("http://localhost:8088/api/v1/admin/rentReview", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<History>>() {
                }).getBody();
    }



    
//-------
}
