package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j(topic = "/ USER_DAO")
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    public UserDaoImpl() {
        super();
        clazz = User.class;
    }

    @Override
    public User findByLogin(String login) {
        User user = entityManager.find(User.class, login);
        if (user == null) {
            log.debug("Object {} not found", login);
            return null;
        } else {
            log.debug("Object {} was foun", login);
            return user;
        }
    }
}
