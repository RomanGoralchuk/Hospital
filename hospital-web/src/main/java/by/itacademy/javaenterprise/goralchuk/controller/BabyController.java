package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.entity.Baby;
import by.itacademy.javaenterprise.goralchuk.service.BabyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/baby")
public class BabyController {

    @Autowired
    private BabyService babyService;

    @GetMapping(value = "")
    public ResponseEntity<List<Baby>> getPersons() {
        List<Baby> products = babyService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
