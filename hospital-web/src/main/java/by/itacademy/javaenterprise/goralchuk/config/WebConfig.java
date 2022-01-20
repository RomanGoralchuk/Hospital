package by.itacademy.javaenterprise.goralchuk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"by.itacademy.javaenterprise.goralchuk"})
@EnableWebMvc
public class WebConfig {
}
