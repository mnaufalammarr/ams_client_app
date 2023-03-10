package mii.mcc72.ams_client_app.services;

import lombok.AllArgsConstructor;
import mii.mcc72.ams_client_app.models.Asset;
import mii.mcc72.ams_client_app.models.History;
import mii.mcc72.ams_client_app.models.Report;
import mii.mcc72.ams_client_app.models.User;
import mii.mcc72.ams_client_app.models.dto.*;
import mii.mcc72.ams_client_app.util.ExcelHelper;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private RestTemplate restTemplate;

    public Asset getQty(int id) {
        return restTemplate.exchange("http://localhost:8088/api/v1/admin/getQty/"+id, HttpMethod.GET,null,
                new ParameterizedTypeReference<Asset>() {
                }).getBody();
    }
    public ResponseData<History> reviewReqRent(int id , ReviewRentDTO reviewRentDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/history/review_rent/"+id, HttpMethod.PUT,new HttpEntity<>(reviewRentDTO),
                new ParameterizedTypeReference<ResponseData<History>>() {
                }).getBody();
    }
    public ResponseData<Report> reportRent(int id , ReportDTO reportDTO) {
        return restTemplate.exchange("http://localhost:8088/api/v1/report/"+id, HttpMethod.PUT,new HttpEntity<>(reportDTO),
                new ParameterizedTypeReference<ResponseData<Report>>() {
                }).getBody();
    }
    public User changeStatus(int id) {
        return restTemplate.exchange("http://localhost:8088/api/v1/admin/change-status/"+id, HttpMethod.PUT,null,
                new ParameterizedTypeReference<User>() {
                }).getBody();
    }

    public ResponseData<List<RegistrationDTO>> registerFinanceFromExcel(List<RegistrationDTO> registrationDTOS){
        return restTemplate.exchange("http://localhost:8088/api/excel/regis-finance", HttpMethod.POST, new HttpEntity<>(registrationDTOS),
                new ParameterizedTypeReference<ResponseData<List<RegistrationDTO>>>() {
                }).getBody();
    }
}
