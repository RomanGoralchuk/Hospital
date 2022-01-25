package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j(topic = "/ USER_DAO")
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {

    @Override
    public List<User> findAllPermittedInformationAboutUsers() {
        return null;
    }
}
