package com.bookclub.service;

import java.util.List;

public interface GenericDao<E, K> {

    // Return a list of objects of type E.
    List<E> list(String key);
    
 // Return a list of objects of type E.
    List<E> list();

    // Return an object of type E by type K value.
    E find(K key);
}
