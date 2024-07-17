package com.fsje.dairy.common.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Value("#{'${staticPatterns}'.split(',')}")
	private String[] staticPatterns;
    @Value("#{'${authExcludePatterns}'.split(',')}")
	private String[] authExcludePatterns;
	
	//Cors 설정
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	    configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Content-Type", "Authorization", "X-XSRF-token"));
	    configuration.setAllowCredentials(false);
	    configuration.setMaxAge(3600L);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

	//
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .formLogin(Customizer.withDefaults())
            .formLogin(login -> login
                    .loginPage("/login")
                    .successHandler(new SimpleUrlAuthenticationSuccessHandler("/"))
                    .permitAll()
            )
            .authorizeHttpRequests(authorizeRequest -> authorizeRequest
                            .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                            .requestMatchers(AntPathRequestMatcher.antMatcher("/user")).permitAll()
                            .requestMatchers(AntPathRequestMatcher.antMatcher(Arrays.toString(authExcludePatterns))).permitAll()
                            .anyRequest().authenticated()
            )
            .headers(headersConfigurer -> headersConfigurer
            	.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
            );

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 리소스 spring security 대상에서 제외
        return (web) -> web
                    .ignoring()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                    .requestMatchers(AntPathRequestMatcher.antMatcher(Arrays.toString(staticPatterns)));
    }
}


/*
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.erp.frontweb.common.login.entrypoint.AjaxAwareAuthenticationEntryPoint;
import com.erp.frontweb.common.login.handler.CustomLogoutSuccessHandler;
import com.erp.frontweb.common.login.handler.LoginFailureHandler;
import com.erp.frontweb.common.login.handler.LoginSuccessHandler;
import com.erp.frontweb.common.login.provider.CustomAuthenticationProvider;

@SuppressWarnings("deprecation")
@Configuration
@ConfigurationProperties(prefix = "system")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private List<String> staticPatterns;
	private List<String> authExcludePatterns;
	public void setStaticPatterns(List<String> staticPatterns) {
		this.staticPatterns = staticPatterns;
	}
	public void setAuthExcludePatterns(List<String> authExcludePatterns) {
		this.authExcludePatterns = authExcludePatterns;
	}
	@Bean
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler("/main");
	}

	@Bean
	public AuthenticationFailureHandler loginFailureHandler() {
		return new LoginFailureHandler("/login");
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		CustomLogoutSuccessHandler logoutSuccessHandler = new CustomLogoutSuccessHandler();
		return logoutSuccessHandler;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Autowired
	CustomAuthenticationProvider authenticationProvider;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(staticPatterns.stream().toArray(String[]::new));
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProcess").failureUrl("/login?error")
			.defaultSuccessUrl("/main", true)
			.usernameParameter("username").passwordParameter("password")
			.successHandler(loginSuccessHandler())
			.failureHandler(loginFailureHandler())
			.and().exceptionHandling()
			.authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"))
			.and()
			.headers().frameOptions().disable()
			.and()
			.cors()
			.and()
			.csrf().disable().authorizeRequests()
			.antMatchers(authExcludePatterns.stream().toArray(String[]::new)).permitAll()
			.anyRequest().authenticated();

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").logoutSuccessHandler(logoutSuccessHandler()).invalidateHttpSession(true);

		http.authenticationProvider(authenticationProvider);
	}

}
*/
