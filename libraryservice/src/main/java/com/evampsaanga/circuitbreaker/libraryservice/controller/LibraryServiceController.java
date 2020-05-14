package com.evampsaanga.circuitbreaker.libraryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evampsaanga.circuitbreaker.libraryservice.delegate.LibraryServiceDelegate;

@RestController
public class LibraryServiceController {
	
	@Autowired
	LibraryServiceDelegate bookServiceDelegate;

	@RequestMapping(value = "/getLibraryDetails/{libraryname}", method = RequestMethod.GET)
	public String getBooks(@PathVariable String libraryname) {
		System.out.println("Going to call book service to get data!");
		return bookServiceDelegate.callBookService(libraryname);
	}
	
}
