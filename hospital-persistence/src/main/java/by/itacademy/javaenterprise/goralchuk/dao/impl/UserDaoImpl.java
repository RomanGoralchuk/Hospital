package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import by.itacademy.javaenterprise.goralchuk.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

/*    @Override
    public List<User> findAll() {
        try {
            List<User> userList = entityManager
                    .createQuery("select " +
                            "id, userInfo.name,userInfo.surname, userInfo.email, userInfo.phone " +
                            "from User")
                    .getResultList();
            return userList;
        } catch (Exception e) {
            log.error("Transaction failed {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }*/
}
