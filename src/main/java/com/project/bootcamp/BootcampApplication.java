package com.project.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

		// Configurando o OpenAPI
		@Bean // Considerar ela para subir
		public OpenAPI customOpenAPI() {
			return new OpenAPI()
			.info(new Info()
			.title("Projeto criado para o bootcamp DIO - Santander")
			.version("1.0")
			.termsOfService("http://swagger.io/terms")
			.license(new License().name("Apache 2.0").url("http://springdoc.org")));
		}
		// URL TO SEE THE API DOCUMENTATION
		//http://localhost:8080/bootcamp/swagger-ui.html

}
