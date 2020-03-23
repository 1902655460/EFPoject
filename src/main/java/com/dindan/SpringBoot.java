package com.dindan;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author：十亿少女的梦
 * @Date：2019/11/4 13:37
 */
public class SpringBoot extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DdPojectApplication.class);
    }
}
