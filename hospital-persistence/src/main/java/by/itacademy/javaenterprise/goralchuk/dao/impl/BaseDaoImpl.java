package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.Dao;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@Slf4j(topic = "/ BASE_DAO")
@Repository
@Transactional
public class BaseDaoImpl<T> implements Dao<T> {
    private Class<T> clazz;
    @PersistenceContext
    @Getter
    private EntityManager entityManager;

    @Override
    public void saveOrUpdate(T entity, Long id) {
        try {
            if (id != null) {
                entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
            }
            log.debug("The save transaction was successful");
        } catch (Exception e) {
            log.error("Error add transaction {}", e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        T entity = entityManager.find(clazz, id);
        if (entity == null) {
            log.debug("Object ID {} not found", id);
        }
        return entity;
    }

    @Override
    public long deleteById(Long id) {
        try {
            T entity = entityManager.getReference(clazz, id);
            entityManager.remove(entity);
            log.debug("The save transaction was successful");
            return id;
        } catch (Exception e) {
            log.error("Transaction failed {}", e.getMessage(), e);
            return 0;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(clazz);
            Root<T> root = query.from(clazz);
            query.select(root);
            log.debug("The save transaction was successful");
            return entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            log.error("Transaction failed {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
