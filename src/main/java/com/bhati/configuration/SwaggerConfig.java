package com.bhati.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.SimplePluginRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket api() {
	       return new Docket(DocumentationType.SWAGGER_2).select()
	    	         .apis(RequestHandlerSelectors.any())
	    	         .paths(PathSelectors.any())
	    	         .paths(Predicate.not(PathSelectors.regex("/error.*")))
	    	         .build();    
	 }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Bhati Movie Ticker Platform API")
				.description("Bhati Movie Ticker Platform API Reference")
				.termsOfServiceUrl("http://bhati.com")
				.licenseUrl("kaushalbhati2@gmail.com").version("1.0").build();
	}
}