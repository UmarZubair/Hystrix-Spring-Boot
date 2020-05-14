package com.evampsaanga.circuitbreaker.bookservice.domain;

public class Book {
	private String title;
	private String genre;

	
	public Book(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookGenre() {
		return genre;
	}

	public void setBookGenre(String genre) {
		this.genre = genre;
	}
}
