package com.evampsaanga.circuitbreaker.bookservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evampsaanga.circuitbreaker.bookservice.domain.Book;

@RestController
public class BookServiceController {

	private static Map<String, List<Book>> BooksDB = new HashMap<String, List<Book>>();

	static {
		BooksDB = new HashMap<String, List<Book>>();

		List<Book> booksList = new ArrayList<Book>();
		Book bookObj = new Book("To Kill a MockingBird", "Fiction");
		booksList.add(bookObj);
		bookObj = new Book("Lord of the Rings", "Fantasy");
		booksList.add(bookObj);

		BooksDB.put("NationalLibrary", booksList);

		booksList = new ArrayList<Book>();
		bookObj = new Book("The Great Gatsby", "Fiction");
		booksList.add(bookObj);
		bookObj = new Book("Harry Potter", "Fantasy");
		booksList.add(bookObj);

		BooksDB.put("StateLibrary", booksList);

	}

	@RequestMapping(value = "/getBookDetailsForLibrary/{libraryname}", method = RequestMethod.GET)
	public List<Book> getStudents(@PathVariable String libraryname) {
		System.out.println("Getting Book details for " + libraryname);

		List<Book> bookList = BooksDB.get(libraryname);
		if (bookList == null) {
			bookList = new ArrayList<Book>();
			Book book = new Book("Not Found", "N/A");
			bookList.add(book);
		}
		return bookList;
	}
}
