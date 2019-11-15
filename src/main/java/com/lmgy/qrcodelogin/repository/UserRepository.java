package com.lmgy.qrcodelogin.repository;

import com.lmgy.qrcodelogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lmgy
 * @date 2019/11/15
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUserId(String userId);

}
