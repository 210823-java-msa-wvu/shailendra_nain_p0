package dev.shailendra.repositories;

import java.util.List;

public interface CrudRepository<T> {

    //Create
    T add(T t);

    //Read
    T getById(Integer id);

    List<T> getAll();

    //Update
    void update(Integer id);

    //Delete
    void delete(Integer id);

}
