package by.itacademy.javaenterprise.goralchuk.entity;

import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@OptimisticLocking
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctor-generator")
    @GenericGenerator(name = "doctor-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "D"),
            strategy = "by.itacademy.javaenterprise.goralchuk.generatorid.IdGenerator")
    private String doctor_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User username;
    @Embedded
    private UserInfo userInfo;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    private List<Complains> complainsList;
}
