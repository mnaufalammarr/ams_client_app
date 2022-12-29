package mii.mcc72.ams_client_app.models;

import lombok.Data;

@Data
public class Report {

    private int id;
    private String dateAccident;
    private String descDamage;
    private String descIncident;
    private int penalty;
    private Employee employee;
}
