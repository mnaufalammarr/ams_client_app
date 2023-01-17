/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.Employee;
import mii.mcc72.ams_client_app.models.dto.RegistrationDTO;
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
public class RegistrationService {
    private RestTemplate restTemplate;
    
    public String registrationEmployeeAccount(RegistrationDTO registrationDTO) {
        return restTemplate.exchange("http://localhost:8088/api/registration", HttpMethod.POST,new HttpEntity<>(registrationDTO),
                new ParameterizedTypeReference<String>() {
                }).getBody();
    }
    
    public String registrationFinanceAccount(RegistrationDTO registrationDTO) {
        return restTemplate.exchange("http://localhost:8088/api/registration/finance", HttpMethod.POST,new HttpEntity<>(registrationDTO),
                new ParameterizedTypeReference<String>() {
                }).getBody();
    }
    
}
