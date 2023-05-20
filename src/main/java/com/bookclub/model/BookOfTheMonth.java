package com.bookclub.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class BookOfTheMonth {

	@Id
	private String id;
	@NotEmpty(message="ISBN is a required field.")
	private String isbn;
	private Integer month;
	
	public BookOfTheMonth() {
	}

	public BookOfTheMonth(String id, String isbn, Integer month) {
		this.id = id;
		this.isbn = isbn;
		this.month = month;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return String.format("BookOfTheMonth{id=%s, month=%s, isbn=%s}", id, month, isbn);
	}
	
}
