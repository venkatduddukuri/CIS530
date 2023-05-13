package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;



public class WishlistItem {

	@Id
	private String id;

	@NotNull
	@NotEmpty(message="ISBN is a required field.")
	private String isbn;
	@NotNull
	@NotEmpty(message="Title is a required field.")
	private String title;
	
	public WishlistItem() {
	}

	public WishlistItem(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}
	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "WishlistItem [id=" + id + ", isbn=" + isbn + ", title=" + title + ", username=" + username + "]";
	}
}
