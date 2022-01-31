package by.itacademy.javaenterprise.goralchuk.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AuthoritiesKey implements Serializable {
    private String username;
    @Enumerated
    private RoleUser authority = RoleUser.ROLE_USER;
}
