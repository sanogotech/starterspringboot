package com.macrosoft.starterjavaspringbootfull;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

@SpringBootApplication
public class StarterjavaspringbootfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterjavaspringbootfullApplication.class, args);
	}
	
	 
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
	 }

}
