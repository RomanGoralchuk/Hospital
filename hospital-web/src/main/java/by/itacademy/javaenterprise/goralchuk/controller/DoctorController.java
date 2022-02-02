package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.entity.Doctor;
import by.itacademy.javaenterprise.goralchuk.exception.NoFoundException;
import by.itacademy.javaenterprise.goralchuk.util.Message;
import by.itacademy.javaenterprise.goralchuk.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private Message message;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "")
    public ResponseEntity<List<Doctor>> getPersons() {
        List<Doctor> products = doctorService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        doctor.getUsername()
                .setPassword("{bcrypt}" + passwordEncoder
                        .encode(doctor.getUsername().getPassword()));
        Doctor newDoctor = doctorService.saveOrUpdate(doctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findDoctorByID(@PathVariable("id") String id) {
        Optional<Doctor> newUser = doctorService.findById(id);
        if (newUser.isEmpty()) {
            throw new NoFoundException("No found user " + id);
        }
        return new ResponseEntity<>(newUser.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message>  deleteUserByID(@PathVariable("id") String id) {
        doctorService.deleteById(id);
        String mess = "Doctor " + id + " deleted";
        message.setMessage(mess);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
