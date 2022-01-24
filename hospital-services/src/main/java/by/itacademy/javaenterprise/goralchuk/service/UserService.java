package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.dao.impl.BaseDaoImpl;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private BaseDaoImpl<User> baseDao;

    public List<User> findAllUsers() {
        List<User> patientList = null;
        try {
            patientList = baseDao.findAll();
        } catch (Exception e) {
            log.warn("Can't found items", e);
        }
        return patientList;
    }
}
