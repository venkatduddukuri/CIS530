package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemBookDao implements BookDao {
    private List<Book> books;
    public MemBookDao() {
        books = new ArrayList<>();
        books.add(new Book("1234567890", "Book 1", "This is Book 1", 10, Arrays.asList("Author 1")));
        books.add(new Book("2345678901", "Book 2", "This is Book 2", 20, Arrays.asList("Author 2", "Author 3")));
        books.add(new Book("3456789012", "Book 3", "This is Book 3", 30, Arrays.asList("Author 4")));
    }
    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {

        for (Book book:this.books){
            if(book.getIsbn().equals(key)){
                return book;
            }
        }
        return new Book();
    }
}
