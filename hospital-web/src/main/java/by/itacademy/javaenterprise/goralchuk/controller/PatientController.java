package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.dto.PatientDto;
import by.itacademy.javaenterprise.goralchuk.entity.Doctor;
import by.itacademy.javaenterprise.goralchuk.entity.Patient;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import by.itacademy.javaenterprise.goralchuk.exception.NoFoundException;
import by.itacademy.javaenterprise.goralchuk.service.PatientService;
import by.itacademy.javaenterprise.goralchuk.util.MapperUtil;
import by.itacademy.javaenterprise.goralchuk.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private Message message;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "")
    public ResponseEntity<List<PatientDto>> getPatient() {
        List<Patient> patientList = patientService.findAll();
        List<PatientDto> listDto = MapperUtil.convertList(patientList, this::convertToPatientDto);
        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        patient.getUsername()
                .setPassword("{bcrypt}" + passwordEncoder
                        .encode(patient.getUsername().getPassword()));
        Patient newPatient = patientService.saveOrUpdate(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientDto> findPatientByID(@PathVariable("id") String id) {
        Optional<Patient> newUser = patientService.findById(id);
        if (newUser.isEmpty()) {
            throw new NoFoundException("No found user " + id);
        }
        return new ResponseEntity<>(convertToPatientDto(newUser.get()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> deletePatientByID(@PathVariable("id") String id) {
        patientService.deleteById(id);
        String mess = "Patient " + id + " deleted";
        message.setMessage(mess);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    private PatientDto convertToPatientDto(Patient patient) {
        return modelMapper.map(patient, PatientDto.class);
    }
}
