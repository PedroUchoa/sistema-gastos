package com.example.teste_maxiprod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class TesteMaxiprodApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteMaxiprodApplication.class, args);
	}

}
