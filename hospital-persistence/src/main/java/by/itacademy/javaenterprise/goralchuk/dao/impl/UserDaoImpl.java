package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import by.itacademy.javaenterprise.goralchuk.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collections;
import java.util.List;

@Slf4j(topic = "/ USER_DAO")
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao{

    public UserDaoImpl() {
        super();
        clazz = User.class;
    }

    @Override
    public List<Object[]> findAllPermittedInformationAboutUsers() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root<User> root = query.from(User.class);
            query.multiselect(root.get("userInfo").get("name"), root.get("userInfo").get("surname"));
            log.debug("The FIND_ALL transaction was successful");
            return entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            log.error("Transaction failed {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
