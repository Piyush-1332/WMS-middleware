package com.cg.gowms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableFeignClients("com.cg.gowms.service")
//@EnableEurekaClient

@SpringBootApplication
public class GreatOutdoorWishlistManagementMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatOutdoorWishlistManagementMicroServiceApplication.class, args);
	}

}
