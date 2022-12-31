package mii.mcc72.ams_client_app.services;

import javafx.beans.binding.ObjectExpression;
import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.Report;
import mii.mcc72.ams_client_app.models.dto.PenaltyDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PenaltyService {

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

}
