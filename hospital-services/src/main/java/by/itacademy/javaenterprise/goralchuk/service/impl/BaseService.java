package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.Dao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import by.itacademy.javaenterprise.goralchuk.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class BaseService<T> implements IService<T> {
    @Autowired
    private Dao<T> baseDao;

    @Override
    public T saveOrUpdate(T entity) {
        return baseDao.saveOrUpdate(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return baseDao.findById(id);
    }

    @Override
    public long deleteById(Long id) {
        return baseDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return baseDao.findAll();
    }
}
