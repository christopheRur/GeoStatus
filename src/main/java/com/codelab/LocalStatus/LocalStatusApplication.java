package com.codelab.LocalStatus;

import com.codelab.LocalStatus.services.GeoStatusServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class LocalStatusApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(LocalStatusApplication.class, args);
	}

}
