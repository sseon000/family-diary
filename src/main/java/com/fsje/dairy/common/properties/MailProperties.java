package com.fsje.dairy.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@ConfigurationProperties(prefix="mail")
@RequiredArgsConstructor
public class MailProperties {
    private final String host;            //SMTP 서버
    private final int    port;            //포트번호
    private final String userName;        //계정
    private final String password;        //비밀번호
    private final String defaultEncoding; //인코딩
}    
