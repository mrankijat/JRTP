package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class MsProj11FallbackMethodWithCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj11FallbackMethodWithCircuitBreakerApplication.class, args);
	}

}
