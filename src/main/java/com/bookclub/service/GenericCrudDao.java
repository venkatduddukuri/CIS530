package com.bookclub.service;

import com.bookclub.model.WishlistItem;

import java.util.List;

public interface GenericCrudDao<E, K> {

    void add(E entity);

    void update(E entity);

    boolean remove(String entity);

    List<E> list(K key); // Return a list of objects of type E.

    E find(K key); // Return an object of type E by type K value.

    List<E> list();
}
