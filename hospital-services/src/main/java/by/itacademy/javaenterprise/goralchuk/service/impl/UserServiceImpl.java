package by.itacademy.javaenterprise.goralchuk.service.impl;

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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void saveOrUpdate(User entity, Long id) {

    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public long deleteById(Long id) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAllPermittedInformationAboutUsers() {
        return null;
    }
}
