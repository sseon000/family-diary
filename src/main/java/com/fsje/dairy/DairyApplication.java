package com.fsje.dairy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.fsje.dairy.common.config.DataBaseConfig;
import com.fsje.dairy.common.config.TomcatWebCustomConfig;
import com.fsje.dairy.common.config.WebMvcConfig;

@SpringBootApplication
//@Import(value = {DataBaseConfig.class, TomcatWebCustomConfig.class, WebMvcConfig.class})
public class DairyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DairyApplication.class, args);
	}

}
