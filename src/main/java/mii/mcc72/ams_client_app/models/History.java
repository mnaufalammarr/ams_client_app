package mii.mcc72.ams_client_app.models;

import lombok.Data;

@Data
public class History {

    private int id;
    private String note;

    private String start;

    private String end;

    private String status;
    private Employee employee;

    private Asset asset;
}
