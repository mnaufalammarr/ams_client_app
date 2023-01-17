package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;
import mii.mcc72.ams_client_app.util.AssetStatus;
import mii.mcc72.ams_client_app.util.RentStatus;

@Data
public class ReviewRentDTO {
    private RentStatus rentStatus;
}
