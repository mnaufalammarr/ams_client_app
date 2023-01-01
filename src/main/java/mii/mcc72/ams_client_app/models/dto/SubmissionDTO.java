package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;

@Data
public class SubmissionDTO {

    private int qty;

    private String name;

    private String description;

    private int price;

    private String image;

    private String date;

    private String status;

    private int employeeId;

    private int categoryId;
}
