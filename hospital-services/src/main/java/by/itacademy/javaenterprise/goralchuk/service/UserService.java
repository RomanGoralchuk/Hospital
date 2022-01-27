package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> findAllPermittedInformationAboutUsers();
}
