package by.itacademy.javaenterprise.goralchuk.dao;

import java.util.List;

public interface UserDao<T> extends Dao<T> {
    List<T> findAllPermittedInformationAboutUsers();
}
