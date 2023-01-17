package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;

@Data
public class ReportDTO {
    private String dateAccident;
    private String descDamage;
    private String descIncident;
    private Long penalty;
    private int adminId;
}
