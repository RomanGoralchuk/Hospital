package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;

import java.util.List;

public interface AuthoritiesService extends BaseService<Authorities, String> {

    List<Authorities> findAuthoritiesByUserId(String username);
}
