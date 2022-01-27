package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.Dao;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@Slf4j(topic = "/ BASE_DAO")
@Repository
public class BaseDao<T> implements Dao<T> {
    Class<T> clazz;
    @PersistenceContext
    @Getter
    protected EntityManager entityManager;

    @Override
    public T saveOrUpdate(T entity) {
        try {
            entityManager.merge(entity);
            log.debug("The SAVE_OR_UPDATE transaction was successful");
            return entity;
        } catch (Exception e) {
            log.error("Error add transaction {}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public T findById(Long id) {
        T entity = entityManager.find(clazz, id);
        if (entity == null) {
            log.debug("Object ID {} not found", id);
            return null;
        } else {
            log.debug("The FIND_BY_ID transaction was successful");
            return entity;
        }
    }

    @Override
    public long deleteById(Long id) {
        try {
            T entity = entityManager.getReference(clazz, id);
            entityManager.remove(entity);
            log.debug("The DELETE transaction was successful");
            return id;
        } catch (Exception e) {
            log.error("Transaction failed {}", e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public List<T> findAll() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(clazz);
            Root<T> root = query.from(clazz);
            query.select(root);
            log.debug("The FIND_ALL transaction was successful");
            return entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            log.error("Transaction failed {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
