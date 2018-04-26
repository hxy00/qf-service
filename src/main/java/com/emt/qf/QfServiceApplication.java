package com.emt.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class QfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QfServiceApplication.class, args);
	}
}
