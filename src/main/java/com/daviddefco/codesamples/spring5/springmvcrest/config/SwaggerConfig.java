package com.daviddefco.codesamples.spring5.springmvcrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
// Commented code is neccesary in case we are not using Spring Boot to
// configure Swagger UI
public class SwaggerConfig { // } extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Contact myContact = new Contact(
            "David de Francisco",
            "https://github.com/daviddefco",
            "david.de.fco@gmail.com");

        return new ApiInfo(
            "Sample NBA REST API",
            "A proof of concept using Spring 5 REST APIs",
            "1.0",
            "Terms of Service: No guarantee provided",
            myContact,
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0",
             new ArrayList<>()
        );
    }
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//            .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//            .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
