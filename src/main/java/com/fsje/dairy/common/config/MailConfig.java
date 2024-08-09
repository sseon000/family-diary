package com.fsje.dairy.common.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fsje.dairy.common.properties.MailProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MailConfig {
	    Properties pt = new Properties();
	    private final MailProperties mailProperties;

	    @Bean
	    public JavaMailSender javaMailService() {
	        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	        javaMailSender.setHost(mailProperties.getHost());
	        javaMailSender.setUsername(mailProperties.getUserName());
	        javaMailSender.setPassword(mailProperties.getPassword());
	        javaMailSender.setPort(mailProperties.getPort());

	        pt.put("mail.smtp.socketFactory.port", mailProperties.getPort());
	        pt.put("mail.smtp.auth", true);
	        pt.put("mail.smtp.starttls.enable", true);
	        pt.put("mail.smtp.starttls.required", true);
	        pt.put("mail.smtp.socketFactory.fallback", false);
	        //pt.put("mail.smtp.socketFactory.class", mailProperties.getSocketFactoryClass());

	        javaMailSender.setJavaMailProperties(pt);
	        javaMailSender.setDefaultEncoding("UTF-8");

	        return javaMailSender;
	    }
	}
