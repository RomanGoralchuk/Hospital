package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.Baby;

import java.util.List;

public interface BabyService extends BaseService<Baby, String> {
    List<Baby> findAll();
}
