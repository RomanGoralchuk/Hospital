package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.Dao;
import by.itacademy.javaenterprise.goralchuk.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Slf4j
@Service
@Transactional
public class BaseService<T> implements IService<T> {
    @Autowired
    private Dao<T> baseDao;
    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public void saveOrUpdate(T entity, Long id) {
        baseDao.saveOrUpdate(entity, id);
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
