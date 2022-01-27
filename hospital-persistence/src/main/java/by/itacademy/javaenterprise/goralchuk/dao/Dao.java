package by.itacademy.javaenterprise.goralchuk.dao;

import java.util.List;

public interface Dao<T> {
    T saveOrUpdate(T entity);

    T findById(Long id);

    long deleteById(Long id);

    List<T> findAll();
}
