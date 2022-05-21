package com.example.lab3.repos;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.io.Serializable;
import java.util.List;

public interface JpaRepository<T, T1 extends Serializable> {
    List<T> findAll();

    List<T> findAll(SpringDataWebProperties.Sort sort);

    List<T> save(Iterable<? extends T> entities);

    void flush();

    T saveAndFlush(T entity);

    void deleteInBatch(Iterable<T> entities);
}
