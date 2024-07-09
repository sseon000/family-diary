package com.fsje.dairy.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @file   : WebMvcConfig
 * @author : KSH
 * @since  : 2024.07.06
 * @brief  : 웹MVC 컨피그
 */
@Configuration
@PropertySource("application.properties") //properties value를 읽어올 파일
//Springboot가 제공하는 autoconfigration을 사용하며 기능 확장을 위해선 @EnableWebMvc 어노테이션을 사용하지 않음
public class WebMvcConfig implements WebMvcConfigurer {

    //uploadPath프로퍼티값을 읽어온다
    @Value("${uploadPath}")
    String uploadPath;
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/upload/**")
        		.addResourceLocations("file:///" + uploadPath + "/");
    	
    	// 리눅스 경우 root에서 시작하는 폴더 경로 지정 할 경우 
    	//.addResourceLocations("file:///usr/download/") 

    	// 리소스 템플릿 경로를 지정할 경우
    	//.addResourceLocations("classpath:/templates/", "classpath:/static/")

    	// 윈도우에서 실행 시 다음과 같은 형태로 드라이브 문자 포함 경로 지정 
    	//.addResourceLocations("file:///C:/webserver_storage/")
    }
}