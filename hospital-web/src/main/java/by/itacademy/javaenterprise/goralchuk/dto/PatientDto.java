package by.itacademy.javaenterprise.goralchuk.dto;

import by.itacademy.javaenterprise.goralchuk.entity.LifeStatus;
import by.itacademy.javaenterprise.goralchuk.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String patient_id;
    @JsonProperty("username")
    private UserDto username;
    private UserInfo userInfo;
    private LifeStatus lifeStatus;
}
