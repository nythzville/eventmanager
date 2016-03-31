package com.eventmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by nathan on 3/31/2016.
 */
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.eventmanager.repo")
@ComponentScan(basePackages = "com.eventmanager")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eventmanager.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                        "Eventmanager",
                        "Eventmanager",
                        "Version 1.0",
                        "",
                        "",
                        "",
                        ""
                ));
    }

}
