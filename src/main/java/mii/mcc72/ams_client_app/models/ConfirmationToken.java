/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.mcc72.ams_client_app.models;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author bintang mada
 */
@Data
public class ConfirmationToken {
    
    private Integer id;
    
    private String token;
    
    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    private User user;
}
