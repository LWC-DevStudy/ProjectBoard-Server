package com.project.board.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //cors를 적용할 URL 패턴 정의
                .allowedOriginPatterns("*")// 자원 공유 허락할 Origin
                .allowedMethods("*") //허락할 HTTP method 지정
                .allowCredentials(true)
                .allowedHeaders("*");
    }
}
