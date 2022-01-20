package by.itacademy.javaenterprise.goralchuk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"by.itacademy.javaenterprise.goralchuk.service"})
public class ServicesConfig {
}