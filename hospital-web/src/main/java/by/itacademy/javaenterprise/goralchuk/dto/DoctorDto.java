package by.itacademy.javaenterprise.goralchuk.dto;

import by.itacademy.javaenterprise.goralchuk.entity.Specialization;
import by.itacademy.javaenterprise.goralchuk.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private String doctor_id;
    @JsonProperty("username")
    private UserDto username;
    @Embedded
    private UserInfo userInfo;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
}
