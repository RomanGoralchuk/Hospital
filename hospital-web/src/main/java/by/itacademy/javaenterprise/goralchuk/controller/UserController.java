package by.itacademy.javaenterprise.goralchuk.controller;

import by.itacademy.javaenterprise.goralchuk.dto.DoctorDto;
import by.itacademy.javaenterprise.goralchuk.dto.UserDto;
import by.itacademy.javaenterprise.goralchuk.entity.Doctor;
import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;
import by.itacademy.javaenterprise.goralchuk.entity.security.AuthoritiesKey;
import by.itacademy.javaenterprise.goralchuk.entity.security.RoleUser;
import by.itacademy.javaenterprise.goralchuk.exception.NoFoundException;
import by.itacademy.javaenterprise.goralchuk.service.AuthoritiesService;
import by.itacademy.javaenterprise.goralchuk.util.Message;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import by.itacademy.javaenterprise.goralchuk.service.UserService;
import by.itacademy.javaenterprise.goralchuk.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthoritiesService authoritiesService;

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getAllUsers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "username") String sortBy) {
        List<User> list = userService.findAll(pageNo, pageSize, sortBy);
        List<UserDto> listDto = MapperUtil.convertList(list, this::convertToUserDto);
        return new ResponseEntity<>(listDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserByID(@PathVariable("id") String id) {
        Optional<User> newUser = userService.findById(id);
        if (newUser.isEmpty()) {
            throw new NoFoundException("No found user " + id);
        }
        return new ResponseEntity<>(convertToNoPassUser(newUser.get()), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUserStatus(@PathVariable("id") String id,
                                                 @RequestBody User newUser) {
        Optional<User> user = userService.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.get().setEnabled(newUser.getEnabled());
        newUser = userService.saveOrUpdate(user.get());
        return new ResponseEntity<>(convertToNoPassUser(newUser), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/authorities")
    public ResponseEntity<List<Authorities>> findUserAuthorities(@PathVariable("id") String id) {
        List<Authorities> authoritiesList = authoritiesService.findAuthoritiesByUserId(id);
        if (authoritiesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authoritiesList, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/authorities")
    public ResponseEntity<Authorities> addAuthoritiesToUser(@RequestBody Authorities authorities) {
        Authorities newAuthorities = authoritiesService.saveOrUpdate(authorities);
        return new ResponseEntity<>(newAuthorities, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}/authorities")
    public ResponseEntity<Message> deleteAllRoles(@PathVariable("id") String id) {
        authoritiesService.deleteAll(id);
        String mess = "All roles for " + id + " deleted";
        Message message = new Message();
        message.setMessage(mess);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}/authorities/{role}")
    public ResponseEntity<Message> deleteRole(@PathVariable("id") String id,
                                              @PathVariable("role") String role) {
        RoleUser roleUser = RoleUser.valueOf(role.toUpperCase());
        authoritiesService.deleteById(new AuthoritiesKey(id, roleUser));
        String mess = "Role " + role + " for " + id + " deleted";
        Message message = new Message();
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
