package com.lmgy.qrcodelogin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, name = "user_id")
    private String userId;
    @Column(nullable = false, name = "user_password")
    private String userPassword;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_avatar")
    private String userAvatar;
    @Column(name = "user_phone")
    private String userPhone;

}
