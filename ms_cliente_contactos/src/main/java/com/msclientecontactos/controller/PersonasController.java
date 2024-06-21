package com.msclientecontactos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonasController {

	@Autowired
	RestTemplate template;
	
	String url = "hhtp://localhost:8080";
	
}
