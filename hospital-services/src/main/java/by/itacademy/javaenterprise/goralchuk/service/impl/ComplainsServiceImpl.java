package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.ComplainsRepository;
import by.itacademy.javaenterprise.goralchuk.entity.Complains;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import by.itacademy.javaenterprise.goralchuk.service.BaseService;
import by.itacademy.javaenterprise.goralchuk.service.ComplainsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ComplainsServiceImpl implements ComplainsService {

    @Autowired
    private ComplainsRepository complainsRepository;

    @Override
    public Complains saveOrUpdate(Complains entity) {
        return complainsRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Complains> findById(Long id) {
        return complainsRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        complainsRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Complains> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Complains> pagedResult = complainsRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Complains> findAllComplainsByPatientId(String patientId) {
        return complainsRepository.findAllComplainsByPatientId(patientId);
    }
}
