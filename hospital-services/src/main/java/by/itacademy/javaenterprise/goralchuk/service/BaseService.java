package by.itacademy.javaenterprise.goralchuk.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

    T saveOrUpdate(T entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    public List<T> findAll(Integer pageNo, Integer pageSize, String sortBy);
}
