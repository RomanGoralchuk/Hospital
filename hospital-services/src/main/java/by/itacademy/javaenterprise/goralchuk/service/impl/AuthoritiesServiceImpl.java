package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.AuthoritiesRepository;
import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;
import by.itacademy.javaenterprise.goralchuk.service.AuthoritiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public List<Authorities> findAuthoritiesByUserId(String username) {
        
        return authoritiesRepository.findAuthoritiesByUserId(username);
    }

    @Override
    public Authorities saveOrUpdate(Authorities entity) {
        return null;
    }

    @Override
    public Optional<Authorities> findById(String s) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public List<Authorities> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }
}
