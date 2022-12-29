package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
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
        return restTemplate.exchange("http://localhost:8088/api/v1/user/available", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Asset>>() {
                }).getBody();
    }
    public List<Report> getPenalty() {
        return restTemplate.exchange("http://localhost:8088/api/v1/user/penalty", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Report>>() {
                }).getBody();
    }
}
