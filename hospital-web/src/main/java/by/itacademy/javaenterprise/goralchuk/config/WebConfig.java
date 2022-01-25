package by.itacademy.javaenterprise.goralchuk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.itacademy.javaenterprise.goralchuk.controller"})
public class WebConfig implements WebMvcConfigurer {
}
