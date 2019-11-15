package com.lmgy.qrcodelogin.repository;

import com.lmgy.qrcodelogin.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lmgy
 * @date 2019/11/15
 */
public interface AuthRepository extends JpaRepository<Auth, Integer> {

    Auth getAuthByAuthToken(String authToken);

}
