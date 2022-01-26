package by.itacademy.javaenterprise.goralchuk.dao.impl;

import by.itacademy.javaenterprise.goralchuk.dao.UserDao;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j(topic = "/ USER_DAO")
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao{

    public UserDaoImpl() {
        super();
        clazz = User.class;
    }

    @Override
    public List<User> findAllPermittedInformationAboutUsers() {
        return null;
    }
/*    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveOrUpdate(User entity, Long id) {
        
    }

    @Override
    public User findById(Long id) {
        User entity = entityManager.find(User.class, id);
        if (entity == null) {
            log.debug("Object ID {} not found", id);
            return null;
        } else {
            return entity;
        }
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
    }*/
}
