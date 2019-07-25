package com.ideagen.pojo.exp.webservice.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.ideagen.pojo.exp.webservice.entity")
@EnableJpaRepositories(basePackages = {"com.ideagen.pojo.exp.webservice.repository"})
@SpringBootApplication(scanBasePackages = {"com.ideagen.pojo.exp.webservice.repository", "com.ideagen.pojo.exp.webservice.springweb"})
public class PojoExpWebserviceSpringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PojoExpWebserviceSpringwebApplication.class, args);
	}

}
