package com.lmgy.qrcodelogin.service.impl;

import com.lmgy.qrcodelogin.entity.Auth;
import com.lmgy.qrcodelogin.entity.IpResult;
import com.lmgy.qrcodelogin.entity.Message;
import com.lmgy.qrcodelogin.repository.AuthRepository;
import com.lmgy.qrcodelogin.service.IAuthService;
import com.lmgy.qrcodelogin.util.IPUtil;
import com.lmgy.qrcodelogin.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author lmgy
 * @date 2019/11/15
 */
@Service
@Slf4j
public class AuthServiceImpl implements IAuthService {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    private Environment environment;

    @Override
    public Message addAuthInfo(HttpServletRequest request) {
        String token = UUIDUtil.uuid().replaceAll("-", "");
        String ip = IPUtil.getIpAddress(request);
        // 本地测试的时候,上面获取的IP为127.0.0.1
        // 所以无法通过局域网获得地理位置，因此手动改为外网IP
        String fakeip = "123.147.246.7";
        String address;
        String url = "http://api.map.baidu.com/location/ip?ip=" + fakeip + "&ak=" + environment.getProperty("baidu.ak") + "&coor=bd09ll";

        Mono<IpResult> resp = WebClient.create()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(IpResult.class);

        try {
            address = resp.block().getContent().getAddress();
        } catch (NullPointerException e) {
            address = "江苏省南京市";
        }

        Auth auth = new Auth();
        auth.setUserId("");
        auth.setAuthToken(token);
        auth.setAuthIp(ip);
        auth.setAuthAddress(address);
        auth.setAuthState(0);
        auth.setAuthTime(new Timestamp(System.currentTimeMillis()));
        authRepository.save(auth);

        return new Message(200, "获取口令成功", token);
    }

    @Override
    public Message getAuthInfo(String authToken, String userId, boolean isScan) {
        Auth auth = authRepository.getAuthByAuthToken(authToken);
        // 为空则获取信息失败
        if (auth == null) {
            return new Message(201, "获取口令信息失败", new Auth());
        }
        //手机端访问，如果token等待验证或正在验证，则将token的state和userId更新
        if (isScan && (auth.getAuthState() == 0 || auth.getAuthState() == 2)) {
            auth.setAuthToken(authToken);
            auth.setAuthState(2);
            auth.setUserId(userId);
            authRepository.saveAndFlush(auth);
        }
        return new Message(200, "获取口令信息成功", auth);
    }

    @Override
    public Message setAuthState(String authToken, String userId) {
        //tokenState：0等待验证，1验证成功，2正在验证，3验证失败（过期）
        // 默认token为3，不存在
        int state = 3;
        Auth auth = authRepository.getAuthByAuthToken(authToken);
        if (auth != null) {
            // 获得token的状态
            state = auth.getAuthState();
        }
        Message message = new Message();
        HashMap<String, Integer> hashMap = new HashMap<>(2);
        // token状态为0，等待验证
        if (state == 0 || state == 2) {
            // TODO 要判断token的时间是否已经过期，可以通过时间戳相减获得
            log.info("===" + (System.currentTimeMillis() - auth.getAuthTime().getTime()));
            auth.setAuthToken(authToken);
            auth.setAuthState(1);
            auth.setUserId(userId);
            authRepository.saveAndFlush(auth);

            message.setCode(200);
            message.setMessage("使用口令成功");
            hashMap.put("state", 1);
        } else { // token状态为1或3，失效
            message.setCode(201);
            message.setMessage("使用口令失败");
            hashMap.put("state", 0);
        }
        message.setData(hashMap);
        return message;
    }

    @Override
    public Message cancelAuth(String authToken, String userId) {
        Auth auth = authRepository.getAuthByAuthToken(authToken);
        Message message = new Message();
        HashMap<String, Integer> hashMap = new HashMap<>(2);
        if (auth != null && auth.getUserId().equals(userId)) {
            auth.setAuthState(0);
            authRepository.saveAndFlush(auth);
            message.setCode(200);
            hashMap.put("state", 1);
            message.setData(hashMap);
        }else{
            message.setCode(201);
            message.setMessage("取消验证失败");
            hashMap.put("state", 0);
        }
        return message;
    }

}
