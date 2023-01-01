package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;

@Data
public class RentDTO {

    private String note;

    private String start;

    private String end;

    private int employeeId;

    private int assetId;
}
