package com.fsje.dairy.common.config;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fsje.dairy.common.interceptor.ApiAuthInterceptor;
import com.fsje.dairy.service.DiaryService;

import lombok.RequiredArgsConstructor;

/**
 * @file   : WebMvcConfig
 * @author : KSH
 * @since  : 2024.07.06
 * @brief  : 웹MVC 컨피그
 */
@Configuration
@PropertySource("application.properties") //properties value를 읽어올 파일
@RequiredArgsConstructor //초기화 되지 않은 final필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
//Springboot가 제공하는 autoconfigration을 사용하며 기능 확장을 위해선 @EnableWebMvc 어노테이션을 사용하지 않음
public class WebMvcConfig implements WebMvcConfigurer {

	private final ApiAuthInterceptor apiAuthInterceptor;
    @Value("${uploadPath}")
    private String uploadPath;
    @Value("#{'${staticPatterns}'.split(',')}")
	private List<String> staticPatterns;
    @Value("#{'${authExcludePatterns}'.split(',')}")
	private List<String> authExcludePatterns;
    
    
    /*
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiAuthInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(staticPatterns)
				.excludePathPatterns(authExcludePatterns);
	}
	*/
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	/*
    	if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/")
					.setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
		}
    	
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**")
					.addResourceLocations("classpath:/static/")
					.setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
		}
		*/
    	
    	registry.addResourceHandler("/uploadFile/**")
        		.addResourceLocations("file:///" + uploadPath + "/");
    	
    	
    	
    	// 리눅스 경우 root에서 시작하는 폴더 경로 지정 할 경우 
    	//.addResourceLocations("file:///usr/download/") 

    	// 리소스 템플릿 경로를 지정할 경우
    	//.addResourceLocations("classpath:/templates/", "classpath:/static/")

    	// 윈도우에서 실행 시 다음과 같은 형태로 드라이브 문자 포함 경로 지정 
    	//.addResourceLocations("file:///C:/webserver_storage/")
    }
}

/*
@Configuration
@ConfigurationProperties(prefix = "system")
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private UserHandlerMethodArgumentResolver userHandlerMethodArgumentResolver;
	@Autowired
	private JsonParamHandlerMethodArgumentResolver jsonParamHandlerMethodArgumentResolver;
	@Autowired
	private PageParamHandlerMethodArgumentResolver pageParamHandlerMethodArgumentResolver;
	@Autowired
	private ApiAuthInterceptor apiAuthInterceptor;

	private List<String> staticPatterns;
	private List<String> authExcludePatterns;
	private String localeAttributeName;

	public void setStaticPatterns(List<String> staticPatterns) {
		this.staticPatterns = staticPatterns;
	}

	public void setAuthExcludePatterns(List<String> authExcludePatterns) {
		this.authExcludePatterns = authExcludePatterns;
	}

	public void setLocaleAttributeName(String localeAttributeName) {
		this.localeAttributeName = localeAttributeName;
	}
	
	@Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/main");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}
	@Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {

		return new RequestContextListener();
    }
	
	@Bean
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(
				Jackson2ObjectMapperBuilder.json().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
						.build());
		converter
				.setSupportedMediaTypes(Collections.singletonList(MediaType.parseMediaType("application/vnd.spring-boot.actuator.v2+json")));
		return converter;
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(jsonParamHandlerMethodArgumentResolver);
		argumentResolvers.add(pageParamHandlerMethodArgumentResolver);
		argumentResolvers.add(userHandlerMethodArgumentResolver);

	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setLocaleAttributeName(localeAttributeName);
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistrationBean() {
		FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<XssEscapeServletFilter>();
		registrationBean.setFilter(new XssEscapeServletFilter());
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}
	
}
*/