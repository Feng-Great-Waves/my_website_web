package com.sentiment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/9 14:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sentiment.mapper")
public class AuthApplication {
    public static void main(String[] args){
        SpringApplication.run(AuthApplication.class,args);
    }

}
