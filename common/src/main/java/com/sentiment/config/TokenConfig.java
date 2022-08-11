package com.sentiment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:29
 */
@Configuration
public class TokenConfig {

    /*JWT对称加密*/
    private static final String TOKEN_STORE = "Authorization";
    @Autowired
    private DataSource dataSource;

    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(TOKEN_STORE);
        return converter;
    }

    @Bean(name = "tokenStore")
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean(name = "jwtTokenStore")
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(tokenConverter());
    }
}
