package com.dindan.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LogCostFilter loginInterceptor = new LogCostFilter();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/","/login","/regUser","/log","/**/*.css", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg","/**/*.jpeg", "/**/*.gif", "/**/fonts/*","/js/lay/modules/*.js","/**/*.doc","/**/*.docx","/**/*.xls","/**/*.xlsx");
    }
}
