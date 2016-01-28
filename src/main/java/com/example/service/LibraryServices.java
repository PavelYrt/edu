package com.example.service;

import java.util.Collection;

public interface LibraryServices<T, ID> {

    Collection<T> findAll();

    T findOne(ID id);

    T create(T entity);

    T update(T entity);

    void delete(ID id);
}
