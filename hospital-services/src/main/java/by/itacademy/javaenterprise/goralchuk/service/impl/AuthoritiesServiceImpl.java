package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.AuthoritiesRepository;
import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;
import by.itacademy.javaenterprise.goralchuk.entity.security.AuthoritiesKey;
import by.itacademy.javaenterprise.goralchuk.service.AuthoritiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<String> findListStringAuthoritiesByUserId(String username) {
        return authoritiesRepository.findAuthoritiesByUserId(username)
                .stream().map(x -> x.getId().getAuthority().getCode()).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Authorities> findAuthoritiesByUserId(String username) {
        return authoritiesRepository.findAuthoritiesByUserId(username);
    }

    @Override
    public Authorities saveOrUpdate(Authorities entity) {
        return authoritiesRepository.save(entity);
    }

    @Override
    public void deleteById(AuthoritiesKey id) {
        authoritiesRepository.deleteById(id);
    }

    @Override
    public void deleteAll(String username) {
        authoritiesRepository.deleteAuthoritiesByUserId(username);
    }
}
