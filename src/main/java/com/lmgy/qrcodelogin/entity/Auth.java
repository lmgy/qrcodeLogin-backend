package com.lmgy.qrcodelogin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, name = "user_id")
    private String userId;
    @Column(nullable = false, name = "auth_token")
    private String authToken;
    @Column(nullable = false, name = "auth_time")
    private Timestamp authTime;
    @Column(nullable = false, name = "auth_ip")
    private String authIp;
    @Column(nullable = false, name = "auth_address")
    private String authAddress;
    @Column(nullable = false, name = "auth_state")
    private Integer authState;

    public Auth(String authToken, String authIp, String authAddress){
        this.authToken = authToken;
        this.authIp = authIp;
        this.authAddress = authAddress;
    }

}
