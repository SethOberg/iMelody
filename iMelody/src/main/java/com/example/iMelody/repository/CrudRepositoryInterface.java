package com.example.iMelody.repository;

import java.util.List;

public interface CrudRepositoryInterface<T, K> {
    List<T> getAll();
    T getById(int id);
    int insert(T object);

    int update(T object);

    int delete(T object);

    int deleteById(int id);

}
