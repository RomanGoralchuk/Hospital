package by.itacademy.javaenterprise.goralchuk.service;

import java.util.List;

public interface IService<T> {
    void saveOrUpdate(T entity, Long id);

    T findById(Long id);

    long deleteById(Long id);

    List<T> findAll();
}
