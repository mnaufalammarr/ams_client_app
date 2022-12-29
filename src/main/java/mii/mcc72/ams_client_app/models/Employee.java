package mii.mcc72.ams_client_app.models;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Department department;
}
