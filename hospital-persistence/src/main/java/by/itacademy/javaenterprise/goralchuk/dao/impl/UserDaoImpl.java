package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j(topic = "/ USER_DAO")
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public List<User> findAllPermittedInformationAboutUsers() {
        return null;
    }
}
