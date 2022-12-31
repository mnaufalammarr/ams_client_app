/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.mcc72.ams_client_app.models.dto;

import lombok.Data;

/**
 *
 * @author bintang mada
 */
@Data
public class AssetDTO {
    private int qty;

    private String name;

    private String description;

    private int price;

    private String image;

//    @NotEmpty(message = "Date is required")
    private String date;

//    @NotEmpty(message = "Status is required")
    private String status;

    private int employeeId;

//    @NotEmpty(message = "Category Asset is required")
    private int categoryId;
}
