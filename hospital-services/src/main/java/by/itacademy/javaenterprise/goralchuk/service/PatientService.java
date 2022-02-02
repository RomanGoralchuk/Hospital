package by.itacademy.javaenterprise.goralchuk.service;

import by.itacademy.javaenterprise.goralchuk.entity.Patient;

import java.util.List;

public interface PatientService extends BaseService<Patient, String> {
    List<Patient> findAll();
}
