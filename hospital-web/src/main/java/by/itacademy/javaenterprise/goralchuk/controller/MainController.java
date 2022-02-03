package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping(value = "")
    public ResponseEntity<Message> getInfoMainPage(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        String hello =  "Hello " + principal.getName() + "!";
        Message message = new Message();
        message.setMessage(hello);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
