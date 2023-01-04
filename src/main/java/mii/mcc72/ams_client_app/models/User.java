package mii.mcc72.ams_client_app.models;

import java.util.List;
import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Boolean isEnabled;
    private Employee employee;
    private List<Role> roles;
    private List<ConfirmationToken> confirmationToken;
}
