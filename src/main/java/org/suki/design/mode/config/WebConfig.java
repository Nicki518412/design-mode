package org.suki.design.mode.config;


import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.suki.design.mode.interceptor.TextInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private TextInterceptor textInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.textInterceptor).addPathPatterns("/**");

    }
}
