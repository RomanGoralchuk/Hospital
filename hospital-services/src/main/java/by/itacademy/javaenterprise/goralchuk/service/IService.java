package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.User;

import java.util.List;

public interface IService<T> {
    T saveOrUpdate(T entity);

    T findById(Long id);

    long deleteById(Long id);

    List<T> findAll();
}
