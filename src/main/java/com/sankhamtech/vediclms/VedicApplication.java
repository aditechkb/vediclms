package com.sankhamtech.vediclms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class VedicApplication {

	public static void main(String[] args) {


		String port = System.getenv().getOrDefault("X_ZOHO_CATALYST_LISTEN_PORT","3000");
		SpringApplication app = new SpringApplication(VedicApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port",port));
		app.run(args);

	}

}
