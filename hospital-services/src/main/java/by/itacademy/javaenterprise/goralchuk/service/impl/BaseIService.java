package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.Dao;
import by.itacademy.javaenterprise.goralchuk.dao.impl.BaseDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import by.itacademy.javaenterprise.goralchuk.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class BaseIService<T> implements IService<T> {
    @Autowired
    @Qualifier(value = "baseDao")
    private Dao<T> dao;

    @Override
    public void saveOrUpdate(T entity, Long id) {

    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public long deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return dao.findAll();
    }
}
