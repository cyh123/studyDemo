package com.cyh.servicezipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
//@EnableEurekaClient
@EnableZipkinServer
public class ServiceZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZipkinApplication.class, args);
	}
}
