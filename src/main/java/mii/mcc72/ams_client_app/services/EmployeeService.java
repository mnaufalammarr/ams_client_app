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

@Service
@AllArgsConstructor
public class EmployeeService {

    private RestTemplate restTemplate;

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
    public History createRentRequest(RentDTO rentDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/rentAsset", HttpMethod.POST,new HttpEntity<>(rentDTO),
                new ParameterizedTypeReference<History>() {
                }).getBody();
    }
    public Asset createSubmissionRequest(SubmissionDTO submissionDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/asset", HttpMethod.POST,new HttpEntity<>(submissionDTO),
                new ParameterizedTypeReference<Asset>() {
                }).getBody();
    }
}
