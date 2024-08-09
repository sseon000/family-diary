package com.fsje.dairy.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@ConfigurationProperties(prefix="mail")
@ConfigurationPropertiesScan
@RequiredArgsConstructor
@Data
public class MailProperties {
	// SMTP 서버
    private final String host;
    // 포트번호
    private final int port;
    // 계정
    private final String userName;
    // 비밀번호
    private final String password;
    // 인코딩
    private final String defaultEncoding;
}
