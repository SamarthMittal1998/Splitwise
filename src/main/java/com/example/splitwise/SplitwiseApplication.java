package com.example.splitwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.example.splitwise.*")
@EnableJpaRepositories(basePackages = "com.splitter")
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
@EnableSwagger2
@EnableTransactionManagement
public class SplitwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

}
