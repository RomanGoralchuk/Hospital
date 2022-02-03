package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.Complains;

import java.util.Date;
import java.util.List;


public interface ComplainsService extends BaseService<Complains, Long> {
    List<Complains> findAllComplains();

}
