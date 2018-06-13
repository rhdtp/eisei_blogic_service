package com.eisei.examen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
@SpringBootApplication
public class ExamenApplication {

	@Value("${endpoint}")
	String endpoint;

	RestTemplate restTemplate;

	public ExamenApplication() {
		restTemplate = new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@GetMapping("/getValue")
	public Prueba obtener(@RequestParam String key) {
		final ResponseEntity<Prueba> responseEntity = restTemplate.getForEntity(endpoint + "?key=" + key, Prueba.class);
		return responseEntity.getBody();
	}
}
