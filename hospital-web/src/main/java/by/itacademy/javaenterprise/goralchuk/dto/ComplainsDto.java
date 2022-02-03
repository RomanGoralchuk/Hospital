package by.itacademy.javaenterprise.goralchuk.dto;

import by.itacademy.javaenterprise.goralchuk.entity.LifeStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplainsDto {
    private Long id;
    private PatientDto patient;
    private String description;
    private Date dateComplain;
    private DoctorDto doctor;
    private String treatment;
    private Date dateStart;
    private Date dateComplete;
    private LifeStatus resultTreatment;
}
