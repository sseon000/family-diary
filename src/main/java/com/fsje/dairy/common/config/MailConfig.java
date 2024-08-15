package com.fsje.dairy.common.config;

import java.util.Properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fsje.dairy.common.properties.MailProperties;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableConfigurationProperties(MailProperties.class)
@Slf4j
public class MailConfig {
    private final MailProperties mailProperties;
    Properties pt = new Properties();
    
    public MailConfig(MailProperties mailProperties) {
    	this.mailProperties = mailProperties;
    }

    @Bean
    public JavaMailSender javaMailService() {
    	/*
    	log.info("host : " + mailProperties.getHost());
    	log.info("userName : " + mailProperties.getUserName());
    	log.info("pw : " + mailProperties.getPassword());
    	log.info("port : " + mailProperties.getPort());
    	*/
    	
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
        javaMailSender.setDefaultEncoding(mailProperties.getDefaultEncoding());

        return javaMailSender;
    }
}
