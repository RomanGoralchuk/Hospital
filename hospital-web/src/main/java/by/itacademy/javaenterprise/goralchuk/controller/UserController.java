package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.dto.UserDto;
import by.itacademy.javaenterprise.goralchuk.exception.MessageException;
import by.itacademy.javaenterprise.goralchuk.exception.NoFoundException;
import by.itacademy.javaenterprise.goralchuk.util.Message;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import by.itacademy.javaenterprise.goralchuk.service.UserService;
import by.itacademy.javaenterprise.goralchuk.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Message message;
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "username") String sortBy) {
        List<User> list = userService.findAll(pageNo, pageSize, sortBy);
        List<UserDto> listDto = MapperUtil.convertList(list, this::convertToUserDto);
        return new ResponseEntity<>(listDto, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.setPassword("{bcrypt}" + passwordEncoder.encode(user.getPassword()));
        User newUser = userService.saveOrUpdate(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserByID(@PathVariable("id") String id) {
        Optional<User> newUser = userService.findById(id);
        if (newUser.isEmpty()) {
            throw new NoFoundException("No found user " + id);
        }
        return new ResponseEntity<>(convertToNoPassUser(newUser.get()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message>  deleteUserByID(@PathVariable("id") String id) {
        userService.deleteById(id);
        String mess = "User " + id + " deleted";
        message.setMessage(mess);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToNoPassUser(User user) {
        modelMapper.typeMap(User.class, User.class).addMappings(mapper -> mapper.skip(User::setPassword));
        return modelMapper.map(user, User.class);
    }
}
