package by.itacademy.javaenterprise.goralchuk.dto;

import by.itacademy.javaenterprise.goralchuk.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String id;
    @JsonProperty("username")
    private UserDto username;
    @Embedded
    private UserInfo userInfo;
}
