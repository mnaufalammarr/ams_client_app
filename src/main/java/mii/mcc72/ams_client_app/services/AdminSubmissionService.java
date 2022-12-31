/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
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
public class AdminSubmissionService {
    private RestTemplate restTemplate;
    
    public Asset createSubmission(Asset asset) {
        System.out.println("submissionservice");
        return restTemplate.exchange("http://localhost:8088/api/v1/asset/", HttpMethod.POST, new HttpEntity(asset),
                new ParameterizedTypeReference<Asset>() {
                }).getBody();
    }
}
