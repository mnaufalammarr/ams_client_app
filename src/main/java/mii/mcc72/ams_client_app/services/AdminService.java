/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.mcc72.ams_client_app.services;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.ResponseData;
import mii.mcc72.ams_client_app.models.dto.ReviewRentDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bintang mada
 */
@Service
@AllArgsConstructor
public class AdminService {
    private RestTemplate restTemplate;

    public List<Object> getPendingAssetsFinance() {
        return restTemplate.exchange("http://localhost:8088/api/v1/user/assets_pending_finance", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Object>>() {
                }).getBody();
    }
   
    // public List<History> getAllRentRequest() {
    //     System.out.println("get all rent request");
    //     return restTemplate.exchange("http://localhost:8088/api/v1/history/", HttpMethod.GET, null,
    //             new ParameterizedTypeReference<List<History>>(){
    //             }).getBody();
    // }

    // public List<Object> getPendingAssetsFinance() {
    //     return restTemplate.exchange("http://localhost:8088/api/v1/user/assets_pending_finance", HttpMethod.GET,null,
    //             new ParameterizedTypeReference<List<Object>>() {
    //             }).getBody();
    // }

    public List<Object> rentReview() {
        return restTemplate.exchange("http://localhost:8088/api/v1/history", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Object>>() {
                }).getBody();
    }
    
    // public List<Asset> getAllSubmissionRequest() {
    //     System.out.println("get all submission request from employee");
    //     return restTemplate.exchange("http://localhost:8088/api/v1/asset/", HttpMethod.GET, null,
    //             new ParameterizedTypeReference<List<Asset>>(){
    //             }).getBody();
    // }

    public ResponseData<History> reviewRentRequest(int id, ReviewRentDTO reviewrentDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/history/review_rent/" + id, HttpMethod.POST, new HttpEntity(reviewrentDTO),
                new ParameterizedTypeReference<ResponseData<History>>() {
                }).getBody();
    }
    
    //-------------
    public List<Object> getPenalty() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/listPenalty", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Object>>() {
                }).getBody();
    }
    public Object getById(int id) {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/penalty/"+id, HttpMethod.GET,null,
                new ParameterizedTypeReference<Object>() {
                }).getBody();
    }

    public List<Asset> getAvailable() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/listAvailable", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Asset>>() {
                }).getBody();
    }

    public Asset getAssetById(int id) {
        return restTemplate.exchange("http://localhost:8088/api/v1/asset/"+id, HttpMethod.GET,null,
                new ParameterizedTypeReference<Asset>() {
                }).getBody();
    }
//    public History createRentRequest(RentDTO rentDTO) {
//        return restTemplate.exchange("http://localhost:8088/api/v1/emp/rentAsset", HttpMethod.POST,new HttpEntity<>(rentDTO),
//                new ParameterizedTypeReference<History>() {
//                }).getBody();
//    }
}
