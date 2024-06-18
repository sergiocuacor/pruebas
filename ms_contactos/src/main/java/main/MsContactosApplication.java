package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"Controller", "DAO", "service"}) // Escanea todos los componentes
@EntityScan(basePackages = {"model"}) // Reconoce las entidades
@EnableJpaRepositories(basePackages = {"DAO"}) // Paquete que implementa JpaRepositories
@SpringBootApplication
public class MsContactosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsContactosApplication.class, args);
	}

}
