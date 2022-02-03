package by.itacademy.javaenterprise.goralchuk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserInfo {
    private String name;
    private String surname;
    private String email;
    private String phone;
}
