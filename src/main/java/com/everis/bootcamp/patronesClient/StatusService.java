package com.everis.bootcamp.patronesClient;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StatusService{
	
	private final static Logger logger = LoggerFactory.getLogger(StatusService.class);
	
	RestTemplate rtplate = new RestTemplate();
	
	String url = "http://localhost:8080/";
	
	public String open() {
		String resourceUrl = url + "open";
		
		ResponseEntity<String> res = rtplate.getForEntity(URI.create(resourceUrl), String.class);
		logger.info("ESTADO: OPEN");
		return res.getBody();
	}
	
	public String close() {
		String resourceUrl = url + "close";
		
		ResponseEntity<String> res = rtplate.getForEntity(URI.create(resourceUrl), String.class);
		logger.info("ESTADO: CLOSE");
		return res.getBody();
	}
	
	public String halfOpen() {
		String resourceUrl = url + "half-open";
		
		ResponseEntity<String> res = rtplate.getForEntity(URI.create(resourceUrl), String.class);
		logger.info("ESTADO: HALF OPEN");
		return res.getBody();
	}
	
	
}

