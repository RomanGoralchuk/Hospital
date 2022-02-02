package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.Baby;
import by.itacademy.javaenterprise.goralchuk.entity.Doctor;

import java.util.List;

public interface DoctorService extends BaseService<Doctor, String> {
    List<Doctor> findAll();
}
