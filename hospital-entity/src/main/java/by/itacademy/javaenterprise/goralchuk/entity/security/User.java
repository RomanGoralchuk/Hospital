package by.itacademy.javaenterprise.goralchuk.entity.security;

import by.itacademy.javaenterprise.goralchuk.entity.Doctor;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@OptimisticLocking
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    @NotNull(message = "Login cannot be null")
    @Max(value = 15, message = "Login should not be greater than 15")
    private String username;
    @NotNull(message = "Password cannot be null")
    @Size(min = 3, max = 15, message = "Password must be between 3 and 15 characters")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private int enabled = 1;
}
