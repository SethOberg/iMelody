package com.example.iMelody.repository;

import java.util.List;

public interface CrudRepositoryInterface<T, K> {
    /**
     * Retrieves all the entries in the database.
     * @params none
     * @return List<T>
     */
    List<T> getAll();

    /**
     * Retrieves an entry based on the given id
     * @param id
     * @return T
     */
    T getById(int id);

    /**
     * Adds a new entry to the database.
     * @param object
     * @return Int
     */
    int insert(T object);

    /**
     * Updates an existing entry.
     * @param object
     * @return Int
     */
    int update(T object);



    int delete(T object);

    int deleteById(int id);

}
