package com.sentiment.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.UUID;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sentiment.constant.Constants;
import com.sentiment.model.UserInfo;
import com.sentiment.model.dto.LoginUserDto;
import com.sentiment.service.IUserInfoService;
import com.sentiment.service.IUserLoginService;
import com.sentiment.utils.RedisCache;
import com.sentiment.utils.Result;
import com.sentiment.utils.SecurityUtil;
import com.sentiment.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/10 17:35
 */
@RestController
@RequestMapping("/auth/user")
public class LoginController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IUserInfoService userInfoService;


    @GetMapping("/captchaImage")
    public Result<?> getCodeImage(){
        String key="";
        String code = "";
        String base64 = "data:image/jpg;base64,";
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            key=UUID.fastUUID().toString();
            code = defaultKaptcha.createText();
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(code);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
            base64 += Base64.encode(jpegOutputStream.toByteArray());
            jpegOutputStream.flush();
            jpegOutputStream.close();
        } catch (IllegalArgumentException | IOException e) {
            // 大致意思是验证生成异常，抛出统一的类
            e.printStackTrace();
        }

        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("base64Img", base64);
        redisCache.setCacheObject(key,code, Constants.CAPTCHA_EXPIRATION,TimeUnit.MINUTES);
        return Result.ok(map);
    }

    @PostMapping("/login")
    public Result<?> userLogin(@RequestBody LoginUserDto loginUser){
        String token = userLoginService.login(loginUser);
        UserInfo userInfo = userInfoService.getUserInfo(loginUser.getUserName());
        if (!StringUtils.isEmpty(token)&& !Objects.isNull(userInfo)){
            redisCache.setCacheObject(token,userInfo,3600,TimeUnit.SECONDS);
        }
        return Result.ok(token,"登入成功");
    }
}
