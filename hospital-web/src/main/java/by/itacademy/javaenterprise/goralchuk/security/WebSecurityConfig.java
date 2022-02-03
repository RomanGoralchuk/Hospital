package by.itacademy.javaenterprise.goralchuk.security;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BasicDataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomSecurityFilter securityFilter = new CustomSecurityFilter();
        securityFilter.setAuthenticationManager(authenticationManager());
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)        // set invalidation state when logout
                .deleteCookies("JSESSIONID")
                .and()
                .httpBasic()
                .and()
                .addFilterAt(
                        securityFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").authenticated()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/").hasAnyRole("ADMIN", "DOCTOR", "MANAGER", "PATIENT")
                .antMatchers("/doctors").hasAnyRole("DOCTOR", "MANAGER")
                .antMatchers("/patients").hasAnyRole("PATIENT")
                .antMatchers("/admin").hasRole("ADMIN")
                .and().formLogin().permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }

}
