package by.itacademy.javaenterprise.goralchuk.service.impl;

import by.itacademy.javaenterprise.goralchuk.dao.DoctorRepository;
import by.itacademy.javaenterprise.goralchuk.dao.UserRepository;
import by.itacademy.javaenterprise.goralchuk.entity.Doctor;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import by.itacademy.javaenterprise.goralchuk.service.DoctorService;
import by.itacademy.javaenterprise.goralchuk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveOrUpdate(Doctor entity) {
        return doctorRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findById(String id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        doctorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Doctor> pagedResult = doctorRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
