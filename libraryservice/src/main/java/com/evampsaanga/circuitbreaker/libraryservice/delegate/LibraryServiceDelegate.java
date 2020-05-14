package com.evampsaanga.circuitbreaker.libraryservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class LibraryServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callBookService_Fallback")
	public String callBookService(String libraryname) {
		System.out.println("Getting book details for " + libraryname);
		String response = restTemplate
				.exchange("http://localhost:8081/getBookDetailsForLibrary/{libraryname}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, libraryname).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "Microservice working and flow is normal.\nLibrary Name -  " + libraryname + "\nBook Details " + response + "\n  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callBookService_Fallback(String libraryname) {
		System.out.println("Book Service is down. Fallback route enabled..");
		return "No Response From Book Service at this moment. Service will be back shortly \n";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
