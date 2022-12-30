package mii.mcc72.ams_client_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Asset {

    private int id;
    private int qty;
    private String name;
    private String description;
    private int price;
    private String image;
    private String date;
    private String approvedStatus;
    private Employee employee;
    private Category category;
}