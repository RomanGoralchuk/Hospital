package by.itacademy.javaenterprise.goralchuk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping(value = "")
    public ResponseEntity<String> getInfoLoginPage(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String hello =  "Hello user " + principal.getName() + "!";
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}
