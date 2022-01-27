package by.itacademy.javaenterprise.goralchuk.config;

import by.itacademy.javaenterprise.goralchuk.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.itacademy.javaenterprise.goralchuk.controller" ,
        "by.itacademy.javaenterprise.goralchuk.security"})
public class WebConfig {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    @Bean
    public Message getMessage(){
        return new Message();
    }
}
