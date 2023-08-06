package com.fpoly.iocare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fpoly.iocare.service"})
@ComponentScan(basePackages = {"com.fpoly.iocare.dao"})
@ComponentScan(basePackages = {"com.fpoly.iocare"})
@EnableJpaRepositories
public class IoCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoCareApplication.class, args);
	}

}
