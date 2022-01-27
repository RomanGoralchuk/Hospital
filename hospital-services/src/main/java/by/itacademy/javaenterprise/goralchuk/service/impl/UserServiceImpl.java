package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.Dao;
import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import by.itacademy.javaenterprise.goralchuk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl extends BaseService<User> implements UserService  {
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllPermittedInformationAboutUsers() {
        return userDao.findAllPermittedInformationAboutUsers();
    }
}
