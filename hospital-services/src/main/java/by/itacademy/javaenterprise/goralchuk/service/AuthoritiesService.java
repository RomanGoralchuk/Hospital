package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;
import by.itacademy.javaenterprise.goralchuk.entity.security.AuthoritiesKey;

import java.util.List;

public interface AuthoritiesService {

    List<String> findListStringAuthoritiesByUserId(String username);

    List<Authorities> findAuthoritiesByUserId(String username);

    Authorities saveOrUpdate(Authorities entity);

    void deleteById(AuthoritiesKey id);

    void deleteAll(String username);
}
