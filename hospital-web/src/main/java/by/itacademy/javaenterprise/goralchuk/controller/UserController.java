package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.dto.UserDto;
import by.itacademy.javaenterprise.goralchuk.entity.Message;
import by.itacademy.javaenterprise.goralchuk.entity.User;
import by.itacademy.javaenterprise.goralchuk.service.UserService;
import by.itacademy.javaenterprise.goralchuk.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Message message;

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getPermittedInformationAboutUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(MapperUtil.convertList(users, this::convertToUserDto), HttpStatus.OK);
        }
    }

/*    @PostMapping(value = "")
    public ResponseEntity<User> addUser(@RequestBody User user){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword("{bcrypt}" + passwordEncoder.encode(user.getPassword()));
        User newUser = userService.saveOrUpdate(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }*/

    @GetMapping(value = "/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable("login") String login) {
        User user = userService.findByLogin(login);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(convertToNoPassUser(user), HttpStatus.CREATED);
        }
    }

    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToNoPassUser(User user) {
        modelMapper.typeMap(User.class, User.class).addMappings(mapper -> mapper.skip(User::setPassword));
        return modelMapper.map(user, User.class);
    }
}
