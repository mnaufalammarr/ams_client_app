/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.mcc72.ams_client_app.services;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Category;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bintang mada
 */
@Service
@AllArgsConstructor
public class CategoryService {
    private RestTemplate restTemplate;
    
    public List<Category> getAll (){
        return restTemplate.exchange("http://localhost:8088/api/v1/category", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Category>>() {
                }).getBody();
    }
    
}
