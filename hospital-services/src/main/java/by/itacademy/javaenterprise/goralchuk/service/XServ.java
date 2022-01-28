package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.User;

import java.util.List;

public interface XServ {
    public List<User> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
}
