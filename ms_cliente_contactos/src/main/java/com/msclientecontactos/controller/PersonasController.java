package com.msclientecontactos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.msclientecontactos.model.Persona;

@RestController
public class PersonasController {

	@Autowired
	RestTemplate template;

	String url = "http://localhost:8080";

	@GetMapping(value = "/personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre, @PathVariable("email") String email,
			@PathVariable("edad") int edad) {
		Persona persona = new Persona(nombre, email, edad);
		template.postForLocation(url + "/contactos", persona);
		Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
		return Arrays.asList(personas);
	}

	
	@GetMapping(value="/personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {
		
		Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
		/*
		 * Utiliza el RestTemplate para hacer una solicitud GET al endpoint
		 * http://localhost:8080/contactos, que se espera devuelva una lista de personas
		 * en formato JSON.
		 * 
		 * Los resultados se convierten en un array de objetos Persona.
		 */
		
			
		
		return Arrays.stream(personas).filter(p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
				.collect(Collectors.toList());
		/*
		 * Convierte el array de Persona en un stream de Java utilizando Arrays.stream(personas). 
		 * Utiliza la función filter del stream para mantener solo las personas cuya edad está entre edad1 y edad2 inclusive. 
		 * p es el parámetro de la expresión lambda. Representa cada elemento del stream (en este caso, cada objeto Persona).
		 * La condición del filtro es p.getEdad() >= edad1 && p.getEdad() <= edad2. 
		 * Finalmente, colecta los resultados filtrados en una lista utilizando Collectors.toList() y los devuelve.
		 */
	}

}
