package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.entity.Doctor;
import by.itacademy.javaenterprise.goralchuk.exception.MessageException;
import by.itacademy.javaenterprise.goralchuk.exception.NoFoundException;
import by.itacademy.javaenterprise.goralchuk.exception.ServerErrorException;
import by.itacademy.javaenterprise.goralchuk.util.Message;
import by.itacademy.javaenterprise.goralchuk.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Message message;
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "")
    public ResponseEntity<List<Doctor>> getAllDoctors(
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy) {
            List<Doctor> list = doctorService.findAll(pageNo, pageSize, sortBy);
            return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
