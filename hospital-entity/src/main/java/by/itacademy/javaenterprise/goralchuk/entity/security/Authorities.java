package by.itacademy.javaenterprise.goralchuk.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorities")
public class Authorities {
    @EmbeddedId
    private AuthoritiesKey id;
}
