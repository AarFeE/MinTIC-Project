package com.proyecto.sistemagestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //para que no pida el logueo
public class ProyectoSistemaDeGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSistemaDeGestionApplication.class, args);


	}

}
