package com.energia.rural.energia_rural_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnergiaRuralApiApplication {

	public static void main(String[] args) {
		System.out.println("====== Variáveis de Ambiente ======");
		System.getenv().forEach((key, value) -> System.out.println(key + ": " + value));
		SpringApplication.run(EnergiaRuralApiApplication.class, args);
	}
}
