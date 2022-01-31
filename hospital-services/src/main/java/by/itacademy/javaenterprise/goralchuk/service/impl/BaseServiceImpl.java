package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.BaseRepository;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BaseServiceImpl {

    @Autowired
    BaseRepository baseRepository;


    public User saveOrUpdate(User entity) {
        return baseRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(String id) {
        return baseRepository.findById(id);
    }

    public void deleteById(String id) {
        baseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<User> pagedResult = baseRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

}
