package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.BabyRepository;
import by.itacademy.javaenterprise.goralchuk.entity.Baby;
import by.itacademy.javaenterprise.goralchuk.service.BabyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class BabyServiceImpl implements BabyService {

    @Autowired
    private BabyRepository babyRepository;


    @Override
    public Baby saveOrUpdate(Baby entity) {
        return null;
    }

    @Override
    public Optional<Baby> findById(String s) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String s) {

    }




    @Override
    public List<Baby> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    @Override
    public List<Baby> findAll() {
        return babyRepository.findAll();
    }
}
