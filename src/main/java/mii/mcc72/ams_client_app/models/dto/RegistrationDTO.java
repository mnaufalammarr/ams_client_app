package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;

@Data
public class RegistrationDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
}
