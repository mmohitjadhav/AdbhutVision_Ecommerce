package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    com.app.util.FileUploadProperties.class
})
public class ECommerce111Application {

	public static void main(String[] args) {
		SpringApplication.run(ECommerce111Application.class, args);
	}

}
