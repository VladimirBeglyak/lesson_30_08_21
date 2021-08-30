package com.example.lesson_30_08_21.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T,K> {

    boolean save(T t);

    boolean update(K id);

    boolean delete(K id);

    Optional<T> findById(K id);

    List<T> findAll();

}
