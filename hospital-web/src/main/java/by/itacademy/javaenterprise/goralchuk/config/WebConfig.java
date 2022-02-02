package by.itacademy.javaenterprise.goralchuk.config;

import by.itacademy.javaenterprise.goralchuk.dto.UserDto;
import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import by.itacademy.javaenterprise.goralchuk.exception.MessageException;
import by.itacademy.javaenterprise.goralchuk.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "by.itacademy.javaenterprise.goralchuk.controller",
        "by.itacademy.javaenterprise.goralchuk.security",
        "by.itacademy.javaenterprise.goralchuk.exception"
})
public class WebConfig {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    @Bean
    public Message getMessage() {
        return new Message();
    }

    @Bean
    public MessageException getMessageException() {
        return new MessageException();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
