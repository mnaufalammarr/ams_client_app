package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;
import mii.mcc72.ams_client_app.util.AssetStatus;

@Data
public class ReviewAssetDTO {
    private AssetStatus assetStatus;
}
