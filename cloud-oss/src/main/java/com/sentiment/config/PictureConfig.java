package com.sentiment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/18 11:14
 */
@Configuration
public class PictureConfig implements WebMvcConfigurer {
    @Value("${picture.dir}")
    private String picDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + picDir);
    }

}
