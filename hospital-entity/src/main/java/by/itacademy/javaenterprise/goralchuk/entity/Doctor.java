package by.itacademy.javaenterprise.goralchuk.entity;

import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(generator = "doctor-generator")
    @GenericGenerator(name = "doctor-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "D"),
            strategy = "by.itacademy.javaenterprise.goralchuk.generatorid.IdGenerator")
    private Long id;
    @Enumerated
    @NotNull(message = "Add specialization!")
    private Specialization specialization;
    @Embedded
    private UserInfo userInfo;
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;*/
}
