package com.infinity.bank.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.infinity.bank.api.interceptor.RequestInterceptor;
@Configuration
public class AppConfig implements WebMvcConfigurer{
  
    @Autowired
    RequestInterceptor productServiceInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(productServiceInterceptor);
    }
}
