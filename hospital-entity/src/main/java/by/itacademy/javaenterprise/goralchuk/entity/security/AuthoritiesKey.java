package by.itacademy.javaenterprise.goralchuk.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AuthoritiesKey implements Serializable {
    private String username;
    @Enumerated(EnumType.STRING)
    private RoleUser authority = RoleUser.ROLE_USER;
}
