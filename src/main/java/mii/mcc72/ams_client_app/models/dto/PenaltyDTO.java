package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PenaltyDTO {
    private String nameAsset;
    private String imgAsset;
    private Date dateAccident;

    private String descDamage;

    private String descIncident;

    private Long penalty;
}
