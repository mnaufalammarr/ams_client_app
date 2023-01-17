package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.Category;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.dto.RentDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private RestTemplate restTemplate;

    public List<Category> getAll() {
        return restTemplate.exchange("http://localhost:8088/api/v1/category", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Category>>() {
                }).getBody();
    }
}
