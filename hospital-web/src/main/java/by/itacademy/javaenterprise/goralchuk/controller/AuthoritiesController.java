package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.service.AuthoritiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class AuthoritiesController {
    @Autowired
    private AuthoritiesService authoritiesService;

}
