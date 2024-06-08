package com.fsje.dairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.fsje.dairy.common.config.DataBaseConfig;

@SpringBootApplication
@Import(value = {DataBaseConfig.class})
public class DairyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DairyApplication.class, args);
	}

}
