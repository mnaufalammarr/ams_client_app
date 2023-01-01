package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.Report;
import mii.mcc72.ams_client_app.util.BasicHeader;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class DashboardService {

    private RestTemplate restTemplate;

    public List<Asset> getAvailable() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/available", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Asset>>() {
                }).getBody();
    }
    public List<Report> getPenalty() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/penalty", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Report>>() {
                }).getBody();
    }
    public List<Asset> getSubmission() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/submission", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Asset>>() {
                }).getBody();
    }
    public List<History> getRent() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/rent", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<History>>() {
                }).getBody();
    }

    public List<Object> getPendingAssetsFinance() {
        return restTemplate.exchange("http://localhost:8088/api/v1/emp/assets_pending_finance", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Object>>() {
                }).getBody();
    }
}
