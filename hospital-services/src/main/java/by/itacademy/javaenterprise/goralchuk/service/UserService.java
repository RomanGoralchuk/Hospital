package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.dao.impl.UserDaoImpl;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j(topic = "/ USER_SERVICE")
@Service
public class UserService{
    @Autowired
    private UserDaoImpl userDao;

    public void saveOrUpdate(User entity, Long id) {

    }

    public User findById(Long id) {
        return null;
    }

    public long deleteById(Long id) {
        return 0;
    }

    public List<User> showAllForbiddenInformationAboutUsers() {
        try {
            log.warn("PRIVATE INFO");
            return userDao.findAll();
        } catch (Exception e) {
            log.warn("Can't found items", e);
        }
        return Collections.emptyList();
    }

    public List<User> showAllPermittedInformationAboutUsers() {
        return null;
    }
}
