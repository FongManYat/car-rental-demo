package com.fwy.carrentaldemo.config;

import com.fwy.carrentaldemo.interceptor.JWTInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/carlist","/index","/car")
                .excludePathPatterns("/user/login","/user/signup","/","/web/**","/css/**",
                        "/font-awesome/**","/fonts/**","/img/**","/js/**","/lineicons/**")
        ;
    }
}
